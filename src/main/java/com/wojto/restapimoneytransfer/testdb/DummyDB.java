package com.wojto.restapimoneytransfer.testdb;

import java.util.HashMap;

import com.wojto.restapimoneytransfer.entity.Account;

public class DummyDB {
	
	public static HashMap<Integer, Account> accountList = new HashMap<>();
	
    static {

    	Account account1 = new Account(1, 500, "password1");
    	Account account2 = new Account(2, 5000, "password2");
    	Account account3 = new Account(3, 0, "password3");
    	Account account4 = new Account(4, 10, "password4");
    	Account account5 = new Account(5, 2000, "password5");
    	
    	accountList.put(1, account1);
    	accountList.put(2, account2);
    	accountList.put(3, account3);
    	accountList.put(4, account4);
    	accountList.put(5, account5);
    }

}
