package com.bank.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.bank.dao.UserDao;

public class Bank {
	
	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	private ArrayList<Employee> employees;
	private UserDao uDao;
	
	public Bank(UserDao usr) {
		this.uDao = usr;
	}
	public Bank(String name) {
		this.name = name;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();
		this.employees = new ArrayList<Employee>();
	}

	
	// account uuid
	public String getNewAccountUUID() {
			//inits
			String uuid;
			Random rng = new Random();
			int len = 10;
			boolean nonUnique;
					
			
			do {
				uuid = "";
				for(int c= 0; c<len; c++) {
					uuid +=((Integer)rng.nextInt(10)).toString();
				}
				// check to make sure it's unique
				nonUnique = false;
				for(Account a : this.accounts) {
					if(uuid.compareTo(a.getUUID())==0) {
						nonUnique = true;
						break;
					}
				}
				
			}while(nonUnique);
			
			return uuid;
			
		}
	public void AddAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	public User addUser(String firstName, String lastName, String password) {
		//create a new User object and add it to our list
		User newUser = new User(firstName, lastName, password);
		uDao.createUser(newUser);
		
		newUser= uDao.getUserByUsername(newUser.getUserName());
		//create a saving account for the user and add to User and Bank accounts lists
		Account newAccount = new Account("Saving", newUser, this);
		Account newAccount1 = new Account("checking", newUser, this);

				
		// add to holder and bank lists
		newUser.addAccount(newAccount);
		this.accounts.add(newAccount);
		newUser.addAccount(newAccount1);
		this.accounts.add(newAccount1);
//		
		
		return newUser;
	}
	public User removeUser(String userName) {
		Iterator itr = users.iterator();
		while(itr.hasNext()) {
			if(itr.equals(userName)) {
				itr.remove();
			}
		}
		return null;
	}
	public User userLogin(String userID, String password) {
		
		User u = uDao.getUserByUsername(userID);
			//check user ID is correct
			if(u.getUserName().equals(userID)) {
				if(u.getPassword().equals(password)) {
						System.out.println("you are logged in ");
				}
			}else {
				System.out.println("invalid Credentials");
			}
			return u;
	}
	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "Bank of Shine";
	}


	public Employee addEmployee(String efirstname, String elastname, String epassword) {
		Employee newUser = new Employee(efirstname, elastname, epassword);
		this.employees.add(newUser);
		return newUser;
	}
	public Employee employeeLogin(String empID, String password) {
		//search through list of users
		for(Employee e: this.employees) {
			//check user ID is correct
			if(e.getIdNumber().equals(empID)) {
				if(e.getEpassword().equals(password)) {
					System.out.println("Welcome ");
				return e;
				}else {
					System.out.println("Invalid credentials");
				}
			}
			System.out.println("you tried logging in that does not exist");
		}
		//if we havn't found the user or hava an incorect
		return null;
	}

}
