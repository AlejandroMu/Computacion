package com.example.demo.model;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
@Component
@Log4j2
public class postProcesor implements BeanPostProcessor{
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		
	

		
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) {
				
		log.info(beanName);
		return bean;
	}

}
