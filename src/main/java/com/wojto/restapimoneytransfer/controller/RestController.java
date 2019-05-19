package com.wojto.restapimoneytransfer.controller;

import java.util.HashSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wojto.restapimoneytransfer.App;
import com.wojto.restapimoneytransfer.entity.Account;



@Path("/bank")
public class RestController {
	
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Test";
	}
	
	@GET
	@Path("get-balance")
	@Produces(MediaType.TEXT_PLAIN)
	public double getBalance() {
    	Account account1 = new Account(1, 500, "password1");
		return account1.getBalance();
	}

	
//    static {
//    	HashSet<Account> accountList = new HashSet<Account>();
//
//    	Account account1 = new Account(1, 500, "password1");
//    	Account account2 = new Account(2, 5000, "password2");
//    	Account account3 = new Account(3, 0, "password3");
//    	Account account4 = new Account(4, 10, "password4");
//    	Account account5 = new Account(5, 2000, "password5");
//    	
//    	accountList.add(account1);
//    	accountList.add(account2);
//    	accountList.add(account3);
//    	accountList.add(account4);
//    	accountList.add(account5);
//    }
}
