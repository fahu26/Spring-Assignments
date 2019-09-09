package com.fahim;

public interface BankAccountService {
	public double withdraw(long accountId, double balance) throws LowBalanceException, BankAccountNotFoundException;
	public double deposit(long accountId, double balance);
	public double getBalance(long accountId) throws BankAccountNotFoundException;
	public boolean fundTransfer(long fromAccount, long toAccount, double amont) throws LowBalanceException, BankAccountNotFoundException;
}
