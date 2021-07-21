package com.bank.model;

import java.util.ArrayList;

public class Account {
	private int id;
	private String acountID;
	private User holderUserName;
	private int checkingAccount;
	private int savingAccount;
	private ArrayList<Transaction> transactions;

	

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(User holderUserName, Bank theBank) {
		super();
		
		//set the account name and holder
		this.holderUserName = holderUserName;
		
		//get new account number
		this.acountID = theBank.getNewAccountUUID();
		
		//init transactions
		this.transactions = new ArrayList<Transaction>();
		
	}


	public String getUUID() {
		return this.acountID;
	}	
	
	public String getSummaryLine() {
		
		//get the account's balance
		double balance = this.getBalance();
		
		//format the summary line, depending on the whether the balance is negative
		if(balance >=0) {
			return String.format("%s : $%.02f : %s", this.acountID, balance, this.name);
		}else {
			return String.format("%s : $(%.02f) : %s", this.acountID, balance, this.name);
		}
	}
	
	public double getBalance() {
		double balance = 0;
		for(Transaction t : this.transactions) {
			balance +=t.getAmount();
		}
		return balance;
	}
	public void printTransHistory() {
		
		System.out.println("\nTransaction history for accounts %s\n" + this.acountID);
		for(int t = this.transactions.size()-1; t<=0; t--) {
			System.out.print(this.transactions.get(t));
//					.getSummaryLine());
		}
		System.out.println();
	}
	public void addTransaction(double amount, String memo) {
		// create new transaction object and add it to our list
		Transaction newTrans = new Transaction(amount, memo, this);
		this.transactions.add(newTrans);
	}
	
}
