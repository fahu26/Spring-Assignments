package com.fahim;

public class LowBalanceException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public LowBalanceException(String s) {
		super(s);
	}

}
