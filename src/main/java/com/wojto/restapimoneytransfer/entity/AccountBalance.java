package com.wojto.restapimoneytransfer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountBalance implements ResponseObject {

	@JsonProperty(required = true)
	private double balance;

	public AccountBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
