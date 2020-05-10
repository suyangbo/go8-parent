package com.go8.mall;

import com.go8.mall.pojo.Cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务端购物车的数据结构：map
 * @author cjl
 *
 */
public class CartCache {
	private Map<Long,List<Cart>> carts;
	
	public CartCache() {
		this.carts = new HashMap<>();
	}

	public Map<Long, List<Cart>> getCarts() {
		return carts;
	}

	public void setCarts(Map<Long, List<Cart>> carts) {
		this.carts = carts;
	}
	
}
