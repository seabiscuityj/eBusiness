package com.sean.ebusiness.service.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sean.ebusiness.entity.AdminUser;
import com.sean.ebusiness.repository.admin.AdminRepository;

/**
 * 数据访问层Repository仅由@Mapper注解的接口组成，接口方法与SQL映射文件中SQL相同。
 */


@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminRepository adminRepository;
	@Override
	public String login(AdminUser AdminUser, HttpSession session, Model model) {
		// 这里adminRepository虽然是接口，没有实现类，但是因为其有@Mapper注解，所以调用自身的login方法是可以的
		List<AdminUser> list = adminRepository.login(AdminUser);
		// 不明白为什么返回类型是List<AdminUser>?
		if(list.size() > 0) {//登录成功
			session.setAttribute("AdminUser", AdminUser);
			return "forward:/goods/selectAllGoodsByPage?currentPage=1&act=select";
		}else {//登录失败
			model.addAttribute("errorMessage", "用户名或密码错误！");
			return "admin/login";
		}
	}
}
