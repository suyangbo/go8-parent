package com.go8.admin.common;
/**
 * 
 * mysql分页包装器
 *
 * @author cjl
 */
public class MysqlPageWrapper<T> {
	private int page;
	private int size;
	private int offset;
	private T t;
	
	public MysqlPageWrapper(int page, int size) {
		this.page = page;
		this.size = size;
		this.offset = (this.page - 1)*this.size;
	}
	
	public MysqlPageWrapper(int page, int size, T t) {
		this.page = page;
		this.size = size;
		this.offset = (this.page - 1)*this.size;
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public int getPage() {
		return page;
	}

	public int getSize() {
		return size;
	}

	public int getOffset() {
		return offset;
	}
}
