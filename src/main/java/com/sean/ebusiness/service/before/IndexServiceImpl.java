package com.sean.ebusiness.service.before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sean.ebusiness.repository.before.IndexRepository;
@Service
public class IndexServiceImpl implements IndexService {
	@Autowired
	private IndexRepository indexRepository;
	@Override
	public String index(Model model, Integer tid) {
		if(tid == null)
			tid = 0;
		//广告区商品
		model.addAttribute("advertisementGoods", indexRepository.selectAdvertisementGoods());
		//导航栏商品类型
		model.addAttribute("goodsType", indexRepository.selectGoodsType());
		//推荐商品
		model.addAttribute("recommendGoods", indexRepository.selectRecommendGoods(tid));
		//最新商品
		model.addAttribute("lastedGoods", indexRepository.selectLastedGoods(tid));
		return "user/index";
	}
	@Override
	public String goodsDetail(Model model, Integer id) {
		//广告区商品
		model.addAttribute("advertisementGoods", indexRepository.selectAdvertisementGoods());
		//导航栏商品类型
		model.addAttribute("goodsType", indexRepository.selectGoodsType());
		//商品详情
		model.addAttribute("goods", indexRepository.selectAGoods(id));
		return "user/goodsDetail";
	}
	@Override
	public String searchGoods(Model model, String mykey) {
		//广告区商品
		model.addAttribute("advertisementGoods", indexRepository.selectAdvertisementGoods());
		//导航栏商品类型
		model.addAttribute("goodsType", indexRepository.selectGoodsType());
		//商品搜索
		model.addAttribute("searchgoods", indexRepository.searchGoods(mykey));
		return "user/searchResult";
	}

	@Override
	public String searchGoodsType(Model model, String goodsTypeKey) {

		return null;
	}
}
