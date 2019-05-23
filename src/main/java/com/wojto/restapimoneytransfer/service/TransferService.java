package com.wojto.restapimoneytransfer.service;

import java.io.IOException;

import com.wojto.restapimoneytransfer.dao.AccountDAO;
import com.wojto.restapimoneytransfer.dao.AccountDAOImpl;
import com.wojto.restapimoneytransfer.entity.Transfer;

public interface TransferService {
	
	// Should be injected, created here for simplicity
	public AccountDAO accountDAO = new AccountDAOImpl();

	public boolean transfer(Transfer transfer) throws IOException;
	public double getBalance(long id);
	
}
