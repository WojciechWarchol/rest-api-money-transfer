package com.wojto.restapimoneytransfer.service;

import java.io.IOException;

import com.wojto.restapimoneytransfer.entity.Transfer;

public class TransferServiceImpl implements TransferService {

	@Override
	public boolean transfer(Transfer transfer) throws IOException {

		if(accountDAO.transferMoney(transfer.getSenderId(),
									transfer.getRecipientId(),
									transfer.getAmmount())) {
			return true;
		}	
		return false;
	}

	@Override
	public double getBalance(long id) {
		
		return accountDAO.getAccount(id).getBalance();
	}

}
