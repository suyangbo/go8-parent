package com.go8.admin.goods.controller;

import com.go8.admin.common.service.ServiceResponse;
import com.go8.goods.pojo.Product;
import com.go8.goods.pojo.ProductSku;
import com.go8.goods.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("adminProductController")
@RequestMapping("/admin")
public class ProductController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ProductService productService;
	
	/*@PostMapping("product")
	public Object add(@RequestBody ProductBody body) {
		try {
			logger.debug("request body to java object: "+body.toString());
			productService.add(body.getProduct(), body.getDetail(), body.getSkus());
			return ServiceResponse.ok();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ServiceResponse.error();
		}
	}*/
	
	@GetMapping("product")
	public Object getProductsByPage(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10")int size,Product product) {
		try {
			logger.debug("product: "+product.toString());
			List<Product> products = productService.getProducts(page, size, product);
			long count = productService.getCount(product);
			Map<String,Object> map = new HashMap<>();
			map.put("total", count);
			map.put("rows", products);
			return ServiceResponse.ok(map);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ServiceResponse.error();
		}
	}
	
	@PutMapping("product/status")
	public Object updateStatus(@RequestBody Product product) {
		try {
			logger.debug("request body to java object: "+product.toString());
			productService.updatePartial(product);
			return ServiceResponse.ok();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ServiceResponse.error();
		}
	}
	
	// 此处注意，内部类一般都要使用静态的，否则序列化失败
	static class ProductBody{
		@Override
		public String toString() {
			return "ProductBody [product=" + product + ", detail=" + detail + ", skus=" + Arrays.toString(skus) + "]";
		}

		private Product product;
		private String detail;
		private ProductSku[] skus;
		
		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}

		public ProductSku[] getSkus() {
			return skus;
		}

		public void setSkus(ProductSku[] skus) {
			this.skus = skus;
		}
	}
}

	
