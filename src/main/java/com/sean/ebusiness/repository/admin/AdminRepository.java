package com.sean.ebusiness.repository.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sean.ebusiness.entity.AdminUser;

@Mapper
public interface AdminRepository {
	// 为什么返回类型是List集合？
	List<AdminUser> login(AdminUser AdminUser);
}
