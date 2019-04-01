package co.edu.icesi.ci.junit.spring.repository;

import co.edu.icesi.ci.junit.spring.model.Order;

public interface SampleRepository {
	
	public Order getOrder(int id);
	public Order createOrder(Order newOrder);
	public Order deleteOrder(int id);
	public Order updateOrder(Order newOrder);

}
