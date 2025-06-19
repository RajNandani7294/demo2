package com.test.Bank.Service;

import java.util.List;

import com.test.Bank.Entity.Account;

public interface AccountService {
	
	public Account CreateAccount(Account account);
	public Account getAccountDetailsByAccountNumber(Long accountNumber);
	public List<Account>getAllAccountDetails();
	public Account depositAmount(Long accountNumber, Double amount);
	public Account withdrawAmount(Long accountNumber, Double amount);
	public void CloseAccount(Long accountNumber);
	

}
