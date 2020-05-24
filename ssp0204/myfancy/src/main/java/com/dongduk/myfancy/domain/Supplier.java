package com.dongduk.myfancy.domain;

public class Supplier {
	
	private int supplier_id;
	private String supplier_name;
	private String supplier_num;
	private String address;
	
	
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_num() {
		return supplier_num;
	}
	public void setSupplier_num(String supplier_num) {
		this.supplier_num = supplier_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
