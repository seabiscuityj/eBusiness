package com.sean.ebusiness.repository.before;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sean.ebusiness.entity.Customer;
@Mapper
public interface UserRepository {
	public List<Customer> isUsed(Customer Customer);
	public int register(Customer Customer);
	public List<Customer> login(Customer Customer);
}
