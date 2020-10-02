package com.sean.ebusiness.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.sean.ebusiness.entity.Customer;

public interface UserService {
	public String isUse(Customer Customer);
	public String register(Customer Customer);
	public String login(Customer Customer, HttpSession session, Model model);
}
