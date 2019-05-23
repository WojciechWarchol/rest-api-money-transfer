package com.wojto.rest_api_money_transfer;

import com.wojto.restapimoneytransfer.entity.Account;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class AccountTest {

	private Account account;
	
	@org.junit.Before
	public void setup() {
		account = new Account(1, 0);
	}
	
	
	@org.junit.Test
	public void depositPositive() throws Exception {
		account.deposit(500);
		assertEquals(500.0, account.getBalance());
	}
	
	@org.junit.Test
	public void depositNegative() throws Exception {
		account.deposit(-500);
		assertEquals(0.0, account.getBalance());
	}
	
	@org.junit.Test
	public void depositRoundUp() throws Exception {
		account.deposit(5.999);
		assertEquals(6.0, account.getBalance());
	}

	@org.junit.Test
	public void depositRoundDown() throws Exception {
		account.deposit(6.001);
		assertEquals(6.0, account.getBalance());
	}
	
	@org.junit.Test
	public void withdrawSufficient() throws Exception {
		account.deposit(500);
		account.withdraw(400);
		assertEquals(100.0, account.getBalance());
	}
	
	@org.junit.Test
	public void withdrawInsfficient() throws Exception {
		account.deposit(500);
		assertFalse(account.withdraw(600));
	}
	
	@org.junit.Test
	public void withdrawnegative() throws Exception {
		account.deposit(500);
		assertFalse(account.withdraw(-500));
	}
}
