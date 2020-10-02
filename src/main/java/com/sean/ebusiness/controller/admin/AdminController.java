package com.sean.ebusiness.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sean.ebusiness.entity.AdminUser;
import com.sean.ebusiness.service.admin.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/toLogin")
	public String toLogin(@ModelAttribute("AdminUser") AdminUser AdminUser) {
		return "admin/login";
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute("AdminUser") AdminUser AdminUser, HttpSession session, Model model) {
		return adminService.login(AdminUser, session, model);
	}
}
