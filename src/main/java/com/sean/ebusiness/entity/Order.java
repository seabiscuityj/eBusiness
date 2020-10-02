package com.sean.ebusiness.entity;

public class Order {
	private Integer id;
	private Integer customer_id;
	private Double amount;
	private Integer status;
	private String orderdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getcustomer_id() {
		return customer_id;
	}
	public void setcustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
}
