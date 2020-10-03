package com.sean.ebusiness.service.before;

import org.springframework.ui.Model;

public interface IndexService {
	public String index(Model model, Integer tid);
	public String goodsDetail(Model model, Integer id);
	public String searchGoods(Model model, String mykey);
	public String searchGoodsType(Model model, String goodsTypeKey);
}
