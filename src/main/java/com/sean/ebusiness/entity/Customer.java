package com.sean.ebusiness.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class Customer {
	private Integer id;
	@NotBlank(message="邮箱必须输入！")
	@Email(message="邮箱格式不正确！")
	private String email;
	@NotBlank(message="密码必须输入！")
	@Length(min=6, max=20, message="密码长度在6到20之间！")
	private String pwd;
	private String repwd;
	private String code;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
}
