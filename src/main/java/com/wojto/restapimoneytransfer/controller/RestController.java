package com.wojto.restapimoneytransfer.controller;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wojto.restapimoneytransfer.entity.Account;
import com.wojto.restapimoneytransfer.entity.Transfer;
import com.wojto.restapimoneytransfer.testdb.DummyDB;



@Path("/bank")
public class RestController {
	
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Test";
	}
	
	@GET
	@Path("get-balance/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public double getBalance(@PathParam("id") int id) {
		
		return DummyDB.accountList.get(id).getBalance();
		
	}
	
//	@GET
//	@Path("jsontest/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Account getAccount(@PathParam("id") int id) {
//
//		Account account = new Account(1, 300, "pass");
//		
//		return account;
//		
//	}
	
	@POST
	@Path("transfer")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean transfer(Transfer transfer) {
		
		return DummyDB.accountList
				.get(transfer.getSenderId())
				.transfer(transfer.getRecipientId(), transfer.getAmmount());
		
	}
	
}
