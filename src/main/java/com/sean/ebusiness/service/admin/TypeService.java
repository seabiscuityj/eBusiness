package com.sean.ebusiness.service.admin;

import org.springframework.ui.Model;

import com.sean.ebusiness.entity.GoodsType;

import javax.servlet.http.HttpSession;

public interface TypeService {
	public String selectAllTypeByPage(Model model, int currentPage);
	public int selectTypeByName(String goodsTypeName);
	public String delete(int id);
	public String addType(GoodsType goodsType, Model model);
	public String searchGoodsType(Model model, String goodsTypeKey);
}
