package com.wojto.restapimoneytransfer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transfer {

	@JsonProperty(required = true)
	private int senderId;
	
	@JsonProperty(required = true)
	private int recipientId;
	
	@JsonProperty(required = true)
	private double ammount;
	
	public Transfer() {}

	public Transfer(int senderId, int recipientId, double ammount) {
		this.senderId = senderId;
		this.recipientId = recipientId;
		this.ammount = ammount;
	}

	public int getSenderId() {
		return senderId;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public double getAmmount() {
		return ammount;
	}
	
	
	
}
