package com.go8.mall.controller;

import org.springframework.web.bind.annotation.RestController;
/*import com.go8.trade.pojo.Order;
import com.go8.trade.pojo.OrderDetail;
import com.go8.trade.pojo.OrderPay;
import com.go8.trade.service.OrderService;*/

@RestController
public class OrderController {
	/*@Autowired
	private OrderService orderService;*/
	
	/*@GetMapping("/order/{id}")
	public Object getById(@PathVariable long id) {
		try {
			Order order = orderService.get(id);
			return ServiceResponse.ok(order);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	@GetMapping("/order/{orderId}/detail")
	public Object getOrderDetailsByOrderId(@PathVariable long orderId) {
		try {
			List<OrderDetail> details = orderService.getDetailsByOrderId(orderId);
			return ServiceResponse.ok(details);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	@PostMapping("/order/add")
	public Object add(@RequestBody Order order) {
		try {
			orderService.add(order);
			return ServiceResponse.ok(order.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	@PostMapping("/order/pay")
	public Object pay(OrderPay orderPay) {
		try {
			orderService.pay(orderPay);
			return ServiceResponse.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}*/
}
