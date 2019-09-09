package com.fahim;

public class BankAccountController {
	public void doOperations() throws BankAccountNotFoundException, LowBalanceException {
	BankAccountRepositoryImpl accountRepositoryImpl = new BankAccountRepositoryImpl();
	BankAccountServiceImpl serviceImpl = new BankAccountServiceImpl();
	accountRepositoryImpl.getBalance(10101);
	accountRepositoryImpl.updateBalance(10101, 2000);

	
	serviceImpl.getBalance(10101); 
	serviceImpl.deposit(10101, 5000);
	serviceImpl.withdraw(10101, 2000);
	serviceImpl.fundTransfer(11101, 10101, 6000);
}
}
