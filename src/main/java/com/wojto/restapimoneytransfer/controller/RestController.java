package com.wojto.restapimoneytransfer.controller;


import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wojto.restapimoneytransfer.entity.AccountBalance;
import com.wojto.restapimoneytransfer.entity.Transfer;
import com.wojto.restapimoneytransfer.entity.RequestStatus;
import com.wojto.restapimoneytransfer.entity.ResponseObject;
import com.wojto.restapimoneytransfer.service.TransferService;
import com.wojto.restapimoneytransfer.service.TransferServiceImpl;




@Path("/bank")
public class RestController {
	
	// Should be injected, created this way for simplicity.
	TransferService service = new TransferServiceImpl();
	
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Test";
	}
	
	@GET
	@Path("get-balance/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseObject getBalance(@PathParam("id") long id) {
		
		double accountBalance;
		
		try {
			accountBalance = service.getBalance(id);
		} catch (NullPointerException e) {
			return new RequestStatus(false);
		}
		
		return new AccountBalance(accountBalance);
	}
	
	@POST
	@Path("transfer")
	@Produces(MediaType.APPLICATION_JSON)
	public RequestStatus transfer(Transfer transfer) throws IOException{
		
		return new RequestStatus(service.transfer(transfer));
		
	}
	
}
