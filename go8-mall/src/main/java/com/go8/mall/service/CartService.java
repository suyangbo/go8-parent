package com.go8.mall.service;

import com.go8.mall.pojo.Cart;

import java.util.List;

public interface CartService {
	List<Cart> sync(List<Cart> carts, long userId);
	
	List<Cart> get(long userId);
	
	List<Cart> remove(String ids, long userId);
}
