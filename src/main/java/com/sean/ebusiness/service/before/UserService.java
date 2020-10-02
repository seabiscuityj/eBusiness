package com.sean.ebusiness.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.sean.ebusiness.entity.Customer;

public interface UserService {
	// 验证该用户是否已被注册，返回的字符串是"yes"或者"no"，"yes"表示该用户已被注册
	public String isUsed(Customer Customer);
	public String register(Customer Customer);
	public String login(Customer Customer, HttpSession session, Model model);
}
