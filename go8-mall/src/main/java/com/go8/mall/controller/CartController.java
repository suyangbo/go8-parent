package com.go8.mall.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.go8.admin.common.service.ServiceResponse;
import com.go8.admin.common.util.JsonUtils;
import com.go8.mall.pojo.Cart;
import com.go8.mall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	
	@GetMapping("/cart.html")
	public String cart() {
		return "cart";
	}
	
	@PostMapping("/cart/sync")
	public @ResponseBody Object sync(long userId,String cart) {
		if(userId==0) {
			return ServiceResponse.illegalArgs();
		}
		try {
			List<Cart> jsonToList = null;
			if(StringUtils.isEmpty(cart)) {
				jsonToList = new ArrayList<>();
			}else {
				jsonToList = JsonUtils.jsonToList(cart, new TypeReference<List<Cart>>() {});
			}
			List<Cart> list = cartService.sync(jsonToList, userId);
			return ServiceResponse.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	@PostMapping("/cart/remove")
	public @ResponseBody Object remove(long userId,String ids) {
		if(userId==0 || StringUtils.isEmpty(ids)) {
			return ServiceResponse.illegalArgs();
		}
		try {
			List<Cart> list = cartService.remove(ids, userId);
			return ServiceResponse.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	@GetMapping("/cart/list")
	public @ResponseBody Object getCart(long userId) {
		try {
			List<Cart> list = cartService.get(userId);
			return ServiceResponse.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
}
