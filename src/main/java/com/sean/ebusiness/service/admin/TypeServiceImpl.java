package com.sean.ebusiness.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sean.ebusiness.entity.Goods;
import com.sean.ebusiness.entity.GoodsType;
import com.sean.ebusiness.repository.admin.TypeRepository;

import javax.servlet.http.HttpSession;

@Service
public class TypeServiceImpl implements TypeService{
	@Autowired
	private TypeRepository typeRepository;
	@Override
	public String selectAllTypeByPage(Model model, int currentPage) {
		//共多少个类型
	  	int totalCount = typeRepository.selectAll();
	  	//计算共多少页
	  	int pageSize = 2;
	  	int totalPage = (int)Math.ceil(totalCount*1.0/pageSize);
	  	List<GoodsType> typeByPage = typeRepository.selectAllTypeByPage((currentPage-1)*pageSize, pageSize);
	    model.addAttribute("allTypes", typeByPage);
	    model.addAttribute("totalPage", totalPage);
	    model.addAttribute("currentPage", currentPage);
		return "admin/selectGoodsType";
	}

	/**
	 * 如果要添加的商品类型已经存在，返回true，否则返回false
	 * @param goodsTypeName 商品类型名称
	 * @return
	 */
	@Override
	public int selectTypeByName(String goodsTypeName) {
		int count = typeRepository.selectTypeByName(goodsTypeName);
		return count;
	}

	@Override
	public String delete(int id) {
		List<Goods> list = typeRepository.selectGoods(id);
		if(list.size() > 0) {
			//该类型下有商品不允许删除
			return "no";
		}else {
			typeRepository.deleteType(id);
			//删除后回到查询页面
			return "/type/selectAllTypeByPage?currentPage=1";
		}
	}
	@Override
	public String addType(GoodsType goodsType, Model model) {
		if (typeRepository.selectTypeByName(goodsType.getTypename()) > 0) {
			model.addAttribute("errorMessage", "该商品类别已经存在，无需重复添加 !");
			return "forward:/type/toAddType";  // 注意：这里不能漏掉forward:
		}
		typeRepository.addType(goodsType);
		return "redirect:/type/selectAllTypeByPage?currentPage=1";
	}

	@Override
	public String searchGoodsType(Model model, String goodsTypeKey) {
		model.addAttribute("searchGoodsType", typeRepository.searchGoodsType(goodsTypeKey));
		return "admin/searchGoodsTypeResult";
	}

}
