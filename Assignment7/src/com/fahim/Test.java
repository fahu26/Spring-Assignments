package com.fahim;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		SpelOperations operations= (SpelOperations) context.getBean("spelOperations");
		System.out.println(operations);
		System.out.println();
		
		LogicalOperations logicalOperations = (LogicalOperations) context.getBean("logicalOperations");
		System.out.println(logicalOperations);
	}

}
