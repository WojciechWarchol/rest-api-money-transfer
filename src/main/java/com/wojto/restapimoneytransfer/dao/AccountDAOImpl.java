package com.wojto.restapimoneytransfer.dao;

import java.io.IOException;

import com.wojto.restapimoneytransfer.entity.Account;
import com.wojto.restapimoneytransfer.testdb.DummyDB;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public Account getAccount(long id) {

		// Very convincing simulation of database accessing.
		Account account = DummyDB.accountList.get(id);

		return account;
	}

	@Override
	public boolean transferMoney(long senderId, long receiverId, double ammount) throws IOException {

		Account senderAccount = getAccount(senderId);
		Account receiverAccount = getAccount(receiverId);
		
		if(senderAccount == null || receiverAccount == null) {
			return false;
		}

		try {
			if (senderAccount.withdraw(ammount)) {
				receiverAccount.deposit(ammount);
			} else {
				throw new IOException();
			}
			// Save account information to DB.

		} catch (Exception e) {
			System.out.println("Failed to execute transfer: " + e);
			// Close connection to DB without saving.
			return false;
		}

		return true;
	}

}
