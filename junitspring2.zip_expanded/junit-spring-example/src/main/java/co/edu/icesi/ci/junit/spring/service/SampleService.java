package co.edu.icesi.ci.junit.spring.service;

import co.edu.icesi.ci.junit.spring.model.Order;

public interface SampleService {

	public String getOrderDescription(int id)throws Exception;
	public String getOrderStringCode(int id)throws Exception;
	public Order getOrder(int id)throws Exception;
	public Order createOrder(Order order) throws Exception;
	public Order updateOrder (Order order)throws Exception;
	public Order deleteOrder (Order order)throws Exception;
	
	
}
