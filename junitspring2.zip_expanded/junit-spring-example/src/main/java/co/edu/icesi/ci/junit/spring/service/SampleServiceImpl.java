package co.edu.icesi.ci.junit.spring.service;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.access.EjbAccessException;

import co.edu.icesi.ci.junit.spring.model.Order;
import co.edu.icesi.ci.junit.spring.repository.SampleRepository;

public class SampleServiceImpl implements SampleService {

	public static final String[] ESTADOS = { "INITIATED", "SHIPPED", "CANCELED", "IN WAREHOUSE" };
	@Autowired
	private SampleRepository repository;

	public String getOrderDescription(int id) throws Exception {
		Order tmp = repository.getOrder(id);
		if (tmp == null) {
			throw new Exception();
		}
		return "Description: " + tmp.getDescription();
	}

	public String getOrderStringCode(int id) throws Exception {
		Order tmp = repository.getOrder(id);
		if (tmp == null) {
			throw new Exception();
		}
		return "Description: " + tmp.getSecurityCode();
	}

	public Order createOrder(Order order) throws Exception {
		boolean ready = verifyOrder(order);
		if (ready) {
			repository.createOrder(order);
		} else {
			throw new Exception();
		}

		return order;
	}

	public boolean verifyOrder(Order order) {
		boolean ready = true;
		ready &= order.description != null;
		ready &= order.orderDate != null;
		ready &= order.orderStatus != null;
		ready &= order.securityCode != null;

		ready &= order.securityCode.length() == 4;
		boolean isEstado = false;
		for (int i = 0; i < ESTADOS.length && ready; i++) {
			isEstado |= order.orderStatus.equalsIgnoreCase(ESTADOS[i]);
		}
		ready &= isEstado;
		return ready;
	}

	public Order getOrder(int id) {

		return repository.getOrder(id);
	}

	public Order updateOrder(Order order) throws Exception {
		boolean right = verifyOrder(order);
		if (!right || getOrder(order.orderId) == null) {
			throw new Exception();
		}
		return repository.updateOrder(order);
	}

	public Order deleteOrder(Order order) throws Exception {
		if (getOrder(order.orderId) == null) {
			throw new Exception();
		}
		return repository.deleteOrder(order.orderId);
	}

}
