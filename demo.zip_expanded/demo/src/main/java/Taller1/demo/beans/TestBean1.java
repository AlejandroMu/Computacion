package Taller1.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestBean1 {
	@Autowired
	private String id;
}
