package com.fahim;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws BankAccountNotFoundException, LowBalanceException {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		BankAccountController accountController = (BankAccountController) context.getBean("controller");
		accountController.doOperations();
	}

}
