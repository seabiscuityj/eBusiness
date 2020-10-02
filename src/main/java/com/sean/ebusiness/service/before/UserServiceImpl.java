package com.sean.ebusiness.service.before;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.sean.ebusiness.entity.Customer;
import com.sean.ebusiness.repository.before.UserRepository;
import com.sean.ebusiness.util.MD5Util;
@Service
public class UserServiceImpl implements UserService {
	@Autowired 
	private UserRepository userRepository;
	@Override
	public String isUse(Customer Customer) {
		if(userRepository.isUse(Customer).size() > 0) {
			return "no";
		}
		return "ok";
	}
	@Override
	public String register(Customer Customer) {
		//对密码MD5加密
		Customer.setPwd(MD5Util.MD5(Customer.getPwd()));
		if(userRepository.register(Customer) > 0) {
			return "user/login";
		}
		return "user/register";
	}
	@Override
	public String login(Customer Customer, HttpSession session, Model model) {
		//对密码MD5加密
		Customer.setPwd(MD5Util.MD5(Customer.getPwd()));
		String rand = (String)session.getAttribute("rand");
		if(!rand.equalsIgnoreCase(Customer.getCode())) {
			model.addAttribute("errorMessage", "验证码错误！");
			return "user/login";
		}
		List<Customer> list = userRepository.login(Customer);
		if(list.size() > 0) {
			session.setAttribute("Customer", list.get(0));
			return "redirect:/";//到首页
		}
		model.addAttribute("errorMessage", "用户名或密码错误！");
		return "user/login";
	}

}
