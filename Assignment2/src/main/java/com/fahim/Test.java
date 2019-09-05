package com.fahim;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
Question question = (Question) context.getBean("question");
question.displayDetails();
System.out.println();
Question2 question2 = (Question2) context.getBean("question2");
question2.displayDetails();
System.out.println();
Question3 question3 = (Question3) context.getBean("question3");
question3.displayDetails();
	}

}
