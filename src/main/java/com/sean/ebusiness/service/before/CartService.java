package com.sean.ebusiness.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.sean.ebusiness.entity.Goods;
import com.sean.ebusiness.entity.Order;

public interface CartService {
	public String putCart(Goods goods, Model model, HttpSession session);
	public String focus(Model model, HttpSession session, Integer gid);
	public String selectCart(Model model, HttpSession session, String act);
	public String deleteCart(HttpSession session, Integer gid);
	public String clearCart(HttpSession session);
	public String submitOrder(Order order, Model model, HttpSession session);
	public String pay(Order order);
	public String myFocus(Model model, HttpSession session);
	public String myOder(Model model, HttpSession session);
	public String orderDetail(Model model, Integer id);
	public String updateUpwd(HttpSession session, String pwd);
}
