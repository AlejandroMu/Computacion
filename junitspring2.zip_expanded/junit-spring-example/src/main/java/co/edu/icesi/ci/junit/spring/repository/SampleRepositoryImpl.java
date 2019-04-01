package co.edu.icesi.ci.junit.spring.repository;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import co.edu.icesi.ci.junit.spring.model.Order;

public class SampleRepositoryImpl implements SampleRepository {
	private HashMap<Integer, Order> list;
	public SampleRepositoryImpl() {
		list=new HashMap<Integer, Order>();
	}
	public Order deleteOrder(int id) {
		return list.remove(id);
	}
	
	public Order createOrder(Order order) {
		return list.put(order.orderId,order);
		
	}
	
	public Order getOrder(int id) {
		
		return list.get(id);
	}
	public Order updateOrder(Order newOrder) {
		list.replace(newOrder.orderId,newOrder);
		return newOrder;
	}
	
	

}
