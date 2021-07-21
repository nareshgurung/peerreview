package com.bank.model;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
//	private Bank theBank;
	private ArrayList<Account> accounts;
	
	public User() {
		accounts = new ArrayList<Account>();
	}
	
	public User(int id, String firstName, String lastName, String password) {
		this.id =id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password =password;
		this.userName = firstName + (new Random().nextInt(900)+ 1000);
		//create empty list of accounts
		this.accounts = new ArrayList<Account>();
		}
	//send user info
	public User(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password =password;
		this.userName = firstName + (new Random().nextInt(900)+ 1000);
		//create empty list of accounts
		this.accounts = new ArrayList<Account>();
		}
	//user to get user info
	public User(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password =password;
		this.userName = username;
			
		//create empty list of accounts
		this.accounts = new ArrayList<Account>();
		}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPassword(String password) {
		this.password =password;
	}
	public String getPassword() {
		return this.password;
	}
	
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	public void printAccountsSummary() {
		System.out.println(this.firstName +"'s accounts summary");
		for(int a =0; a<this.accounts.size(); a++) {
			System.out.println(a+1+")" +  this.accounts.get(a).getSummaryLine());
		}
		System.out.println();
	}
	public int numAccounts() {
		return this.accounts.size();
	}
	public void printAcctTransHistory(int acctIdx) {
		this.accounts.get(acctIdx).printTransHistory();
	}
	public double getAcctBalance(int fromAcct) {
		return this.accounts.get(fromAcct).getBalance();
	}
	public String getAcctUUID(int acctIdx) {
		return this.accounts.get(acctIdx).getUUID();
	}
	
	public void addAcctTransaction(int acctIdx, double amount, String memo) {
		this.accounts.get(acctIdx).addTransaction(amount, memo);
	}

	@Override
	public String toString() {
		return "New user "+ "id" + id + lastName + ", " + firstName + " with ID- " + userName;
	}

}