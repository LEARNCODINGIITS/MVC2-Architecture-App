package com.itts.model;

import java.io.Serializable;

public class Product implements Serializable {
	private int pid;
	private String pname;
	private double price;

	public Product() {

	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
