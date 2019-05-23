package com.wojto.restapimoneytransfer.entity;

public class Account {
	
	private long id;
	private double balance;
	
	public Account() {}
	
	public Account(long id, double balance) {
		this.id = id;
		this.balance = round(balance);
	}

	public long getId() {
		return id;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean withdraw(double ammount) {
		
		ammount = round(ammount);
		
		if(ammount <= balance && ammount >=0) {
			this.balance = balance - ammount;
			return true;
		}
		
		return false;
	}
	
	public boolean deposit(double ammount) {
		
		ammount = round(ammount);
		
		if(ammount >= 0) {
			this.balance += ammount;
			return true;
		}
		
		return false;
	}
	
	
	// Rouding if an ammount with more than 2 decimal places is given.
	private double round(double ammount) {
		return (double)Math.round(ammount * 100d) / 100d;
	}
	
}
