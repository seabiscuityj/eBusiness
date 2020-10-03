package com.sean.ebusiness.controller.before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sean.ebusiness.service.before.IndexService;

@Controller
public class IndexController {
	@Autowired
	private IndexService indexService;
	@RequestMapping("/")
	public String index(Model model, Integer tid) {
		return indexService.index(model, tid);
	}
	@RequestMapping("/goodsDetail")
	public String goodsDetail(Model model, Integer id) {
		return indexService.goodsDetail(model, id);
	}
	@RequestMapping("/searchGoods")
	public String searchGoods(Model model, String mykey) {
		return indexService.searchGoods(model, mykey);
	}
}
