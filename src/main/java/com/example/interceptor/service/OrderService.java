/**
 * 
 */
package com.example.interceptor.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.interceptor.pojo.Order;

/**
 * @author Aqeel
 *
 */
@Service
public class OrderService {
	
	Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	Map<Integer, Order> orderMap = new HashMap<>();

	public Map getAllOrders() {
		logger.info("");
		
		return orderMap;
	}
	
	public Map addOrder(Order order) {
		logger.info(">>> inside addOrder() >> OrderService");
		
		int id = orderMap.size()+1;
		
		order.setId(id);
		
		orderMap.put(id, order);
		
		logger.info("Successfully added.");
		return orderMap;
	}
	
	public Order getLastOrderDetails() {
		logger.info(">>> inside getLastOrderDetails() >> OrderService");
		
		Order order = orderMap.get(orderMap.size());
		
		logger.info(">>> ", order);
		
		return order;
	}
	
	public List<Order> getAllOrderDetails() {
		logger.info(">>> inside getAllOrderDetails() >> OrderService");
		
		
		logger.info(">>> ", orderMap);
		
		List<Order> orderList = new ArrayList<>(orderMap.values());
		
		return orderList;
	}
	
}
