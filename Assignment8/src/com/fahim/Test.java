package com.fahim;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Shapes shape = (Shapes) context.getBean("triangle"); 
		shape.draw();
		System.out.println();
		Shapes shape1 = (Shapes) context.getBean("circle");
		shape1.draw();
	}

}
