package com.wojto.restapimoneytransfer.entity;


public class Account {
	
	private int id;
	private double balance;
	private String password;
	
//	String firstName;
//	String lastName;
//	String email;
	
	public Account() {}
	
	public Account(int id, double balance, String password) {
		this.id = id;
		this.balance = round(balance);
		this.password = password;
	}

	public int getId() {
		return id;
	}

	// We probably won't be changing the Id.
//	public void setId(int id) {
//		this.id = id;
//	}

	// If we want to check the password
//	public double getBalance(String password) {
//		if(this.password == password) {
//			return balance;
//		} 
//		System.out.println("Invalid password");
//		return -1.00;
//	}
	
	public double getBalance() {
		return balance;
	}

	// No balance setting, only transfers
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}

	// Getting the password?
//	public String getPassword() {
//		return password;
//	}

	public boolean setPassword(String oldPassword, String newPassword) {
		
		if(this.password == oldPassword) {
		this.password = newPassword;
		return true;
		}
		
		return false;
	}

	public boolean transfer(int recipientId, double ammount) {
		
		ammount = round(ammount);
		
		if(ammount < balance) {
			
			this.balance = balance - ammount;
			// get the Account with the Id
			
			// transfer the ammount to the Recipient Account
			
			// If that returned true, return true here, else add the ammount back
			return true;
		}
		
		return false;
	}
	
	// method for accpeting the transfer 
	public boolean acceptTransfer(double ammount) throws Exception {
		
		double balanceBeforeTransfer = balance;
		
		try {
			this.balance += ammount;
		} catch (Exception e) {
			this.balance = balanceBeforeTransfer;
			return false;
		}
		return true;
	}
	
	// Rouding if an ammount with more than 2 decimal places is given.
	private double round(double ammount) {
		return (double)Math.round(ammount * 100d) / 100d;
	}
	
}
