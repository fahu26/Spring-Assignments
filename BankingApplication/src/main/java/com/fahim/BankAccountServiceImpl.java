package com.fahim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BankAccountServiceImpl implements BankAccountService {
	BankAccountRepositoryImpl impl = new BankAccountRepositoryImpl();
	public double withdraw(long accountId, double balance) throws LowBalanceException, BankAccountNotFoundException {
		double balanceInAccount= impl.getBalance(accountId);
		if(balanceInAccount >= balance) {
			String dbURL = "jdbc:mysql://localhost:3306/SampleDB";
			String username = "root";
			String password = "root@123";
			try {
				Connection conn = DriverManager.getConnection(dbURL, username, password);
				if (conn != null) {
					Statement stmt = conn.createStatement();
					balanceInAccount-=balance;
					 String Query1="update bank_Account set account_balance="+balanceInAccount +" where account_id="+accountId;
					 stmt.executeUpdate(Query1);
					 System.out.println("UpdatedBalance Amount for account_id:"+accountId+" is "+balanceInAccount);
					}
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		else {
			throw new LowBalanceException("Account balance is too low for this transaction");
		}
		
		return balanceInAccount;
	}

	public double deposit(long accountId, double balance) {
		double updatedBalance = impl.updateBalance(accountId, balance);
		return updatedBalance;
	}

	public double getBalance(long accountId) throws BankAccountNotFoundException {
		double balanceInAccount= impl.getBalance(accountId);
		 System.out.println("Balance Amount for account_id:"+accountId+" is "+balanceInAccount);
		return balanceInAccount;
	}

	public boolean fundTransfer(long fromAccount, long toAccount, double amont) throws LowBalanceException,BankAccountNotFoundException {
		// TODO Auto-generated method stub
		boolean isValid=false;
		double balanceInAccount_From= impl.getBalance(fromAccount);
		double balanceInAccount_To= impl.getBalance(toAccount);
		if(balanceInAccount_From>=amont) {
			isValid=true;
			balanceInAccount_From-= amont;
			balanceInAccount_To+= amont;
		String dbURL = "jdbc:mysql://localhost:3306/SampleDB";
		String username = "root";
		String password = "root@123";
		try {
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				 String Query1="update bank_Account set account_balance="+balanceInAccount_To +" where account_id="+toAccount;
				 stmt.executeUpdate(Query1);
				 String Query2="update bank_Account set account_balance="+balanceInAccount_From +" where account_id="+fromAccount;
				 stmt.executeUpdate(Query2);
				}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		}
		else {
			throw new LowBalanceException("Account balance is too low for this transaction");
		}
		return isValid;
	}

}
