package co.edu.icesi.ci.junit.spring.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import co.edu.icesi.ci.unit.model.Order;

public class SampleServiceImpl implements SampleService {
	public static final String[] ESTADOS= {"INITIATED", "SHIPPED", "CANCELED", "IN WAREHOUSE"};
	private HashMap<Integer, Order> list;
	public SampleServiceImpl() {
		list=new HashMap<Integer, Order>();
	}
	public void delete() {
		list.clear();
	}
	public String getOrderDescription(int id) {
		Order existingOrder = list.get(id);
		return existingOrder.description;
	}

	public String getOrderStringCode(int id) {
		Order existingOrder = list.get(id);
		return existingOrder.securityCode;
	}
	
	public Order createOrder(Order order) {
		boolean ready=true;
		ready&=order.description!=null;
		ready&=order.orderDate!=null;
		ready&=order.orderStatus!=null;
		ready&=order.securityCode!=null;
		
		ready&=order.securityCode.length()==4;
		boolean isEstado=false;
		for (int i = 0; i < ESTADOS.length&&ready; i++) {
			isEstado|=order.orderStatus.equalsIgnoreCase(ESTADOS[i]);
		}
		ready&=isEstado;
		if(ready) {
			list.put(order.orderId,order);
		}else {
			order=null;
		}
		
		return order;
	}
	
	public Order getOrder(int id) {
		
		return list.get(id);
	}
	
	

}
