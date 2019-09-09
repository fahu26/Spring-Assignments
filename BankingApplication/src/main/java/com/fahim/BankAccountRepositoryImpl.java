package com.fahim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankAccountRepositoryImpl implements BankAccountRepository {

	public double getBalance(long accountId) throws BankAccountNotFoundException {
		double balance = 0;
		String dbURL = "jdbc:mysql://localhost:3306/SampleDB";
		String username = "root";
		String password = "root@123";
		try {
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String query="Select account_balance from bank_Account where account_Id="+ accountId;
				ResultSet rs = stmt.executeQuery(query);
				if (rs.next()) {
					balance=rs.getDouble(1);
					System.out.println("Balance Amount for account_id:"+accountId+" is "+balance);
				}
				else {
					throw new BankAccountNotFoundException("Bank account does not exist");
				}
			}
			conn.close(); 
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return balance;
	}

	public double updateBalance(long accountId, double newBalance) {
		// TODO Auto-generated method stub
		double updatedBalance=0;
		String dbURL = "jdbc:mysql://localhost:3306/SampleDB";
		String username = "root";
		String password = "root@123";
		try {
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String query="Select account_balance from bank_Account where account_Id="+ accountId;
				ResultSet rs = stmt.executeQuery(query);
				if (rs.next()) {
					updatedBalance=rs.getDouble(1);
					updatedBalance+=newBalance;

					String Query1="update bank_Account set account_balance="+updatedBalance +" where account_id="+accountId;
					stmt.executeUpdate(Query1);
					System.out.println("UpdatedBalance Amount for account_id:"+accountId+" is "+updatedBalance);
				}
				else {
					System.out.println("Account id does not exist");
				}

			}
			conn.close(); 
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return updatedBalance;
	}

}
