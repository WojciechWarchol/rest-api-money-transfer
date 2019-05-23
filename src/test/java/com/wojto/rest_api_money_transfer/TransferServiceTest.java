package com.wojto.rest_api_money_transfer;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.wojto.restapimoneytransfer.entity.Transfer;
import com.wojto.restapimoneytransfer.service.TransferService;
import com.wojto.restapimoneytransfer.service.TransferServiceImpl;

public class TransferServiceTest {
	
	TransferService service;

	@org.junit.Before
	public void setup() throws Exception{
		service = new TransferServiceImpl();
	}
	
	@org.junit.Test
	public void getBalancePositive() throws Exception{
		assertEquals(1000.0, service.getBalance(6));
	}
	
	@org.junit.Test(expected = NullPointerException.class)
	public void getBalanceNegative() throws Exception{
		service.getBalance(7);
	}
	
	@org.junit.Test
	public void transferNegative() throws Exception{
		assertFalse(service.transfer(new Transfer(6, 3, 1000.0)));
		assertEquals(0.0, service.getBalance(6));
		assertEquals(1000.0, service.getBalance(3));
	}
	
	@org.junit.Test
	public void transferPositive() throws Exception{
		assertTrue(service.transfer(new Transfer(6, 3, 1000.0)));
		assertEquals(0.0, service.getBalance(6));
		assertEquals(1000.0, service.getBalance(3));
	}
}
