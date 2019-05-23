package com.wojto.rest_api_money_transfer;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

import com.wojto.restapimoneytransfer.dao.AccountDAO;
import com.wojto.restapimoneytransfer.dao.AccountDAOImpl;

public class AccountDAOTest {

	private AccountDAO accountDAO;
	
	@org.junit.Before
	public void setup() throws Exception {
		accountDAO = new AccountDAOImpl();
	}

	@org.junit.Test
	public void getAccountExisting() throws Exception {
		assertNotNull(accountDAO.getAccount(1));
	}
	
	@org.junit.Test
	public void getAccountNonexisting() throws Exception{
		assertNull(accountDAO.getAccount(7));
	}
	
	@org.junit.Test
	public void transferSufficientFunds() throws Exception{
		
		assertTrue(accountDAO.transferMoney(1, 2, 400));
		assertEquals(100.0, accountDAO.getAccount(1).getBalance());
		assertEquals(5400.0, accountDAO.getAccount(2).getBalance());
	}
	
	@org.junit.Test
	public void transferInsufficientFunds() throws Exception{
		
		assertFalse(accountDAO.transferMoney(1, 2, 400));
		assertEquals(100.0, accountDAO.getAccount(1).getBalance());
		assertEquals(5400.0, accountDAO.getAccount(2).getBalance());
	}
	
	@org.junit.Test
	public void transferWithMissingAccount() throws Exception{
		
		assertFalse(accountDAO.transferMoney(1, 7, 400));
	}
	
	
}