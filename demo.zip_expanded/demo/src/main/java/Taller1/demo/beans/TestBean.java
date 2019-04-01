package Taller1.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
@Lazy
@Repository
public class TestBean {
	
	@Autowired
	private String id;
	
}
