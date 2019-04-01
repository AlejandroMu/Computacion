package com.example.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Person;
import com.example.demo.model.Prototype;
import com.example.demo.model.Singleton;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TallerpreParcialApplicationTests {

	@Autowired
	private Singleton personSingleton;
	@Autowired
	private Singleton personSingleton1;
	@Autowired
	private Prototype personPrototype;
	@Autowired
	private Prototype personPrototype1;
		
	@Test
	public void testSingleton() {
		Person person1=personSingleton.getPerson();
		person1.setFirstName("Pedro");
		Person person2=personSingleton1.getPerson();
		assertTrue(person1.getFirstName().equals(person2.getFirstName()));
	}
	
	
	@Test
	public void testPrototype() {
		Person person1=personPrototype.getPerson();
		person1.setFirstName("Pedro");
		Person person2=personPrototype1.getPerson();
		assertFalse(person1.getFirstName().equals(person2.getFirstName()));
	}

}
