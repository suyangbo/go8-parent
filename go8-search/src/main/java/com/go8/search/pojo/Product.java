package com.go8.search.pojo;

public class Product {
	private long id;
	private int price;
	private String catalog_name;
	private String brand_cname;
	private String brand_ename;
	private String title;
	private String attributes;
	private String picture;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCatalog_name() {
		return catalog_name;
	}
	public void setCatalog_name(String catalog_name) {
		this.catalog_name = catalog_name;
	}
	public String getBrand_cname() {
		return brand_cname;
	}
	public void setBrand_cname(String brand_cname) {
		this.brand_cname = brand_cname;
	}
	public String getBrand_ename() {
		return brand_ename;
	}
	public void setBrand_ename(String brand_ename) {
		this.brand_ename = brand_ename;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
}
