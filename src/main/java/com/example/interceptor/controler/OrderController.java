/**
 * 
 */
package com.example.interceptor.controler;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.interceptor.pojo.Order;
import com.example.interceptor.service.OrderService;

/**
 * @author Aqeel
 *
 */

@RestController
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	public OrderService orderService;
	
	@GetMapping("/getOrder")
	public ResponseEntity<Order> getAnOrder() {
		logger.info(">>> inside getAnOrder() >> OrderController");
		
		Order order = orderService.getLastOrderDetails();
		
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@PostMapping("/order")
	public ResponseEntity<Order> placeAnOrder(@RequestBody Order order) {
		logger.info(">>> inside placeAnOrder() >> OrderController");
		
		order.setOrderDate(new Date());
		
		orderService.addOrder(order);
		
		order.setOrderDescription("Order placed successfully.");
		
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Order>> getAllOrders() {
		logger.info(">>> inside getAnOrder() >> OrderController");
		
		List<Order> orders = orderService.getAllOrderDetails();
		
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}

}
