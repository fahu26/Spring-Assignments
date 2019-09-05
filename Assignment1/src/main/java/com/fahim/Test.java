package com.fahim;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String args[]) {
	ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring.xml");
	 Customer cust= (Customer) applicationContext.getBean("customer");
/*	XML based configuration
 * Customer cust= (Customer) applicationContext.getBean(Customer.class); */
	cust.customerDetails();
}
}
