package com.durgasoft.spring_boot_container;

import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootContainerApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext= SpringApplication.run(SpringBootContainerApplication.class, args);
		//Web strarted dependcy
		
		System.out.println("Count of Bean "+ applicationContext.getBeanDefinitionCount());
		
		String[] beanNames= applicationContext.getBeanDefinitionNames();
		for(String beanName:beanNames) {
			System.out.println("Bean Name :"+beanName);
		}
		
	}

}
