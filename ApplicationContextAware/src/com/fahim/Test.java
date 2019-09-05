package com.fahim;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
Triangle triangle = (Triangle) context.getBean("triangle");
triangle.draw();
	}

}
