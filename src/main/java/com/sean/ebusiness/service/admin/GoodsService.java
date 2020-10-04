package com.sean.ebusiness.service.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.sean.ebusiness.entity.Goods;

public interface GoodsService {
	public String selectAllGoodsByPage(Model model, int currentPage, String act);
	public String addGoods(Goods goods, HttpServletRequest  request, String act) throws IllegalStateException, IOException ;
	public String toAddGoods(Goods goods, Model model);
	public String detail(Model model, Integer id, String act);
	public String delete(Integer id);
	public String searchGoodsByAdmin(Model model, String goodsNameKey, String act);
}
