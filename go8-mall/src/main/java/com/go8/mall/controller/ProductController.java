package com.go8.mall.controller;

import com.go8.admin.common.service.ServiceResponse;
import com.go8.goods.pojo.ProductDetail;
import com.go8.goods.pojo.ProductExt;
import com.go8.goods.pojo.ProductSku;
import com.go8.goods.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	public Object getProductById(long id) {
		try {
			logger.debug("productid: "+id);
			ProductExt product = productService.getProductBrandById(id);
			return ServiceResponse.ok(product);
		} catch (Exception e) {
			logger.error("get product error",e);
			return ServiceResponse.error();
		}
	}
	
	@GetMapping("/detail")
	public Object getProductDetailByProductId(long productId) {
		try {
			logger.debug("productid: "+productId);
			ProductDetail detail = productService.getDetailByProductId(productId);
			return ServiceResponse.ok(detail);
		} catch (Exception e) {
			logger.error("get product detail error",e);
			return ServiceResponse.error();
		}
	}
	
	@GetMapping("/sku")
	public Object getSkusByProductId(long productId) {
		try {
			logger.debug("productid: "+productId);
			List<ProductSku> skus = productService.getSkusByProductId(productId);
			return ServiceResponse.ok(skus);
		} catch (Exception e) {
			logger.error("get product skus error",e);
			return ServiceResponse.error();
		}
	}
}
