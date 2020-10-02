package com.sean.ebusiness.service.admin;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.sean.ebusiness.entity.AdminUser;

public interface AdminService {
	public String login(AdminUser AdminUser, HttpSession session, Model model);
}
