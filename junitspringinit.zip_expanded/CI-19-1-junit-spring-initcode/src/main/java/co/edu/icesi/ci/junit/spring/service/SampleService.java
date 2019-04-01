package co.edu.icesi.ci.junit.spring.service;

import co.edu.icesi.ci.unit.model.Order;

public interface SampleService {

	public String getOrderDescription(int id);
	public String getOrderStringCode(int id);
	public Order getOrder(int id);
	public Order createOrder(Order order);
	public void delete();
	
	
}
