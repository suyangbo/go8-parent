package com.go8.admin.goods.vo;

import java.util.ArrayList;
import java.util.List;

public class CatalogTreeVO {
	private long id;
	private long pid;
	private boolean parent;
	private String title;
	private boolean loading;
	private List<CatalogTreeVO> children = new ArrayList<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public boolean getParent() {
		return parent;
	}
	public void setParent(boolean parent) {
		this.parent = parent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isLoading() {
		return loading;
	}
	public void setLoading(boolean loading) {
		this.loading = loading;
	}
	public List<CatalogTreeVO> getChildren() {
		return children;
	}
	public void setChildren(List<CatalogTreeVO> children) {
		this.children = children;
	}
}
