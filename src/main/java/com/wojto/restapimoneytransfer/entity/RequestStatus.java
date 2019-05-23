package com.wojto.restapimoneytransfer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestStatus implements ResponseObject{
	
	@JsonProperty(required = true)
	private boolean status;

	public RequestStatus(boolean status) {
		this.status = status;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
