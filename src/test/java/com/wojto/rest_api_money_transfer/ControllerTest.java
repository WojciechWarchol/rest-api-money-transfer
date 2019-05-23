package com.wojto.rest_api_money_transfer;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.wojto.restapimoneytransfer.controller.RestController;
import com.wojto.restapimoneytransfer.entity.AccountBalance;
import com.wojto.restapimoneytransfer.entity.RequestStatus;
import com.wojto.restapimoneytransfer.entity.Transfer;

public class ControllerTest {

	private static RestController controller;
	
	@org.junit.BeforeClass
	public static void setup() throws Exception{
		controller = new RestController();
	}
	
	@org.junit.Test
	public void testEndpoint() throws Exception{
		assertEquals("Test", controller.test());
	}
	
	@org.junit.Test
	public void getBalancePositive() throws Exception{
		assertEquals(AccountBalance.class, controller.getBalance(5).getClass());
	}
	
	@org.junit.Test
	public void getBalanceNegative() throws Exception{
		assertEquals(RequestStatus.class, controller.getBalance(7).getClass());
	}
	
	@org.junit.Test
	public void transferPositive() throws Exception {
		assertTrue(controller.transfer(new Transfer(4, 5, 10.0)).getStatus());
		assertEquals(0.0, ((AccountBalance) controller.getBalance(4)).getBalance());
		assertEquals(2010.0, ((AccountBalance) controller.getBalance(5)).getBalance());
	}
	
	@org.junit.Test
	public void transferNegative() throws Exception {
		assertFalse(controller.transfer(new Transfer(4, 5, 10.0)).getStatus());
		assertEquals(0.0, ((AccountBalance) controller.getBalance(4)).getBalance());
		assertEquals(2010.0, ((AccountBalance) controller.getBalance(5)).getBalance());
	}
}
