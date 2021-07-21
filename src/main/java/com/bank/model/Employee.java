package com.bank.model;
import java.util.ArrayList;
import java.util.Random;

public class Employee {
	private String eFirstName;
	private String eLastName;
	private String idNumber;
	private String ePassword;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;

	public Employee(String eName, String eLastName, String epassword ) {
		super();
		this.eFirstName = eName;
		this.eLastName = eLastName;
		this.ePassword = epassword;
		this.idNumber = eLastName + (new Random().nextInt(900)+100);
		
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();

	}

	public String geteFirstName() {
		return eFirstName;
	}

	public void seteFirstName(String eFirstName) {
		this.eFirstName = eFirstName;
	}

	public String geteLastName() {
		return eLastName;
	}

	public void seteLastName(String eLastName) {
		this.eLastName = eLastName;
	}

	public String getIdNumber() {
		return idNumber;
	}
	public String getEpassword() {
		return ePassword;
	}
	public void setPassword(String ePassword) {
		this.ePassword = ePassword;
	}

	@Override
	public String toString() {
		return "Hello " + this.eFirstName + " your idNumber=" + idNumber;
	}
	
	
}
