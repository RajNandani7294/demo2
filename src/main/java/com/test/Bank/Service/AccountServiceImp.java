package com.test.Bank.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Bank.Entity.Account;
import com.test.Bank.Repository.AccountRepo;

@Service
public class AccountServiceImp  implements AccountService{
	
	@Autowired
	 AccountRepo  accountRepo;

	@Override
	public Account CreateAccount(Account account) {
		Account account_save=accountRepo.save(account);
		return account_save;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional <Account> account=accountRepo.findById(accountNumber);
		
		if(account.isEmpty()) {
			throw new RuntimeException("Account not found");
		}
		Account account_found=account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		List<Account>list=accountRepo.findAll();
		return list;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
	   Optional<Account>account=accountRepo.findById(accountNumber);
	   if(account.isEmpty()) {
		   throw new RuntimeException("Account is not present");
	   }
	   Account accountpresent=account.get();
	   double totalBalance=accountpresent.getAccount_balance()+amount;
	   accountpresent.setAccount_balance(totalBalance);
	   accountRepo.save(accountpresent);
		return accountpresent;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		 Optional<Account>account=accountRepo.findById(accountNumber);
		   if(account.isEmpty()) {
			   throw new RuntimeException("Account is not present");
		   }
		   Account accountpresent=account.get();
		   double AccountBalance=accountpresent.getAccount_balance()-amount;
		   accountpresent.setAccount_balance(AccountBalance);
		   accountRepo.save(accountpresent);
			return accountpresent;
	}

	@Override
	public void CloseAccount(Long accountNumber) {
		getAccountDetailsByAccountNumber(accountNumber);
		accountRepo.deleteById(accountNumber);
		
	}
  
	
}
