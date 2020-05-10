package com.go8.mall.controller;

import com.go8.cms.pojo.IndexRoll;
import com.go8.cms.service.IndexRollService;
import com.go8.goods.pojo.ProductDetail;
import com.go8.goods.pojo.ProductExt;
import com.go8.goods.pojo.ProductSku;
import com.go8.goods.service.ProductService;
import com.go8.search.pojo.Product;
import com.go8.search.pojo.SearchedData;
import com.go8.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PageController {
	@Autowired
	private IndexRollService indexRollService;
	@Autowired
	private SearchService searchService;
	@Autowired
	private ProductService productService;

	// 默认转首页
	@GetMapping("/")
	public String defaultPage() {
		return "forward:/index.html";
	}

	@GetMapping("/index.html")
	public String index(Model model) {
		List<IndexRoll> rolls = indexRollService.getIndexRolls();
		model.addAttribute("rolls", rolls);
		return "index";
	}

	@GetMapping("/list.html")
	public String list(String q, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "60") int size, Model model) {
		SearchedData<Product> sd = searchService.searchByKeywords(q, page, size);
		model.addAttribute("sd", sd);
		return "list";
	}

	@GetMapping("/product.html")
	public String product(long id, Model model) {
		ProductExt product = productService.getProductBrandById(id);
		ProductDetail detail = productService.getDetailByProductId(id);
		List<ProductSku> skus = productService.getSkusByProductId(id);
		model.addAttribute("product", product);
		model.addAttribute("detail", detail);
		model.addAttribute("skus", skus);
		return "product";
	}

	@GetMapping("/cartSuccess.html")
	public String cartSuccess(long id, String title, Model model) {
		model.addAttribute("title", title);
		return "cartSuccess";
	}

	@GetMapping("/order.html")
	public String order() {
		return "order";
	}

	@GetMapping("/pay.html")
	public String pay(long orderId, Model model) {
		model.addAttribute("orderId", orderId);
		return "pay";
	}

	@GetMapping("/order/paySuccess.html")
	public String paySuccess(long orderId, Model model) {
		model.addAttribute("orderId", orderId);
		return "paySuccess";
	}

	// 原来sso里的代码
	@GetMapping("/register.html")
	public String register(Model model, String returnUrl) {
		model.addAttribute("returnUrl", returnUrl);
		return "register";
	}

	@GetMapping("/login.html")
	public String login(Model model, String returnUrl) {
		model.addAttribute("returnUrl", returnUrl);
		return "login";
	}

	@GetMapping("/member.html")
	public String member() {
		return "member";
	}

}
