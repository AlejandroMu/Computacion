package Taller1.demo.beans;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class PosProcesBean implements BeanPostProcessor{
	
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		if(bean.getClass().getPackage().getName().equals("Taller1.demo")) {
			log.info("Mi Bean "+beanName);

		}
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		if(!bean.getClass().getPackage().getName().equals("Taller1.demo")) {
			log.info("Bean de Spring; "+beanName);

		}		
		return bean;
	}
}
