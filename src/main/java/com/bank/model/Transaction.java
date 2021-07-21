package com.bank.model;
import java.util.Date;

public class Transaction {
	
	private double amount;
	private String memo;
	
	private Account inAccount;
	
	public Transaction(double amount, Account inAccount) {
		
		this.amount = amount;
		this.inAccount = inAccount;
		this.memo =" ";
	}
	public Transaction(double amount, String memo, Account inAccount) {
		
		// call the two-arg contructor first
		this(amount, inAccount);
		
		//set the memo
		this.memo = memo;
	}
	public double getAmount() {
		return this.amount;
	}
}
