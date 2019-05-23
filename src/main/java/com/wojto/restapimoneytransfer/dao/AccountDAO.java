package com.wojto.restapimoneytransfer.dao;

import java.io.IOException;

import com.wojto.restapimoneytransfer.entity.Account;

public interface AccountDAO {

	public Account getAccount(long id);
	public boolean transferMoney(long senderId, long receiverId, double ammount) throws IOException;
	
}
