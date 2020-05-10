package com.go8.mall.service;

import com.go8.mall.CartCache;
import com.go8.mall.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
	//购物车
	@Autowired
	private CartCache cartCache;
	
	@Override
	public List<Cart> sync(List<Cart> carts,long userId) {
		//同步购物车，如没有就添加新的商品，如有，结果以客户端为准
		List<Cart> cartss = cartCache.getCarts().get(userId);
		if(cartss==null || cartss.size()==0) {
			cartss = carts;
		}else {
			//清除购物车，客户端为准
			if(carts.size()==0) {
				cartss.clear();
			}else {
				for(Cart cart : carts){
					boolean find = false;
					long id = cart.getId();
					for(int i=0;i<cartss.size();i++) {
						if(cartss.get(i).getId()==id) {
							find = true;
							//替换
							cartss.set(i, cart);
							break;
						}
					}
					if(!find) {
						//add
						cartss.add(cart);
					}
				}
			}
		}
		//添加进缓存中
		cartCache.getCarts().put(userId, cartss);
		return cartss;
	}

	@Override
	public List<Cart> get(long userId) {
		return cartCache.getCarts().get(userId);
	}

	@Override
	public List<Cart> remove(String ids, long userId) {
		String[] carts = ids.split(",");
		List<Cart> cartss = cartCache.getCarts().get(userId);
		for(int i=0;i<carts.length;i++) {
			long id = new Long(carts[i]);
			for(int k=0;k<cartss.size();k++) {
				if(id == cartss.get(k).getId()) {
					cartss.remove(k);
					break;
				}
			}
		}
		cartCache.getCarts().put(userId, cartss);
		return cartss;
	}

}
