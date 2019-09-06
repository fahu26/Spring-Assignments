package com.fahim;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
Shapes shape = (Shapes) context.getBean("circle");
shape.draw();
System.out.println();
Shapes shape1 = (Shapes) context.getBean("triangle");
shape1.draw();
	}

}
