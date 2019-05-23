package com.wojto.restapimoneytransfer.testdb;

import java.util.HashMap;

import com.wojto.restapimoneytransfer.entity.Account;

public class DummyDB {
	
	public static HashMap<Long, Account> accountList = new HashMap<>();
	
    static {

    	Account account1 = new Account(1, 500);
    	Account account2 = new Account(2, 5000);
    	Account account3 = new Account(3, 0);
    	Account account4 = new Account(4, 10);
    	Account account5 = new Account(5, 2000);
    	Account account6 = new Account(6, 1000);
    	
    	accountList.put(1l, account1);
    	accountList.put(2l, account2);
    	accountList.put(3l, account3);
    	accountList.put(4l, account4);
    	accountList.put(5l, account5);
    	accountList.put(6l, account6);
    }

}
