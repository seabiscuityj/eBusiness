package com.sean.ebusiness.controller.before;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sean.ebusiness.entity.Customer;
import com.sean.ebusiness.service.before.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/toRegister")
	public String toRegister(@ModelAttribute("Customer") Customer Customer) {
		return "user/register";
	}
	@RequestMapping("/toLogin")
	public String toLogin(@ModelAttribute("Customer") Customer Customer) {
		//@ModelAttribute("Customer")与th:object="${Customer}"相对应
		return "user/login";
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute("Customer") @Validated Customer Customer,
			BindingResult rs, HttpSession session, Model model) {
		if(rs.hasErrors()){//验证失败
	        return "user/login";
	    }
		return userService.login(Customer, session, model);
	}
	@RequestMapping("/isUsed")
	@ResponseBody
	public String isUsed(@RequestBody Customer Customer) {
		return userService.isUsed(Customer);
	}
	@RequestMapping("/register")
	public String register(@ModelAttribute("Customer") @Validated Customer Customer,BindingResult rs) {
		if(rs.hasErrors()){//验证失败
	        return "user/register";
	    }
		return userService.register(Customer);
	}
}
