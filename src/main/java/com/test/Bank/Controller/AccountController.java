package com.test.Bank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.Bank.Entity.Account;
import com.test.Bank.Service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
 private AccountService accountservice;
	
	@PostMapping("/create")
	public ResponseEntity <Account> createaccount(@RequestBody Account account) {
		Account createAccount=accountservice.CreateAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}
	
	@GetMapping("/{accountNumber}")
	
	public Account getAccountDetailsByAccountNumber(@PathVariable Long AccountNumber)
	{
		Account account=accountservice.getAccountDetailsByAccountNumber(AccountNumber);
		return account;
	}
	
	@GetMapping("/getallaccount")
	
	public List<Account> getAllAccount(){
		List<Account>listofaccount=accountservice.getAllAccountDetails();
		return listofaccount;
	}
	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	 public Account depositAccount(@PathVariable Long accountNumber, @PathVariable Double amount)
	 {
		Account account=accountservice.depositAmount(accountNumber, amount);
		return account;	
	 }
	@PutMapping("/withdraw/{accountNumber}/{amount}")
     
	public Account withdrawAccount(@PathVariable Long accountNumber, @PathVariable Double amount)
	 {
		Account account=accountservice.withdrawAmount(accountNumber, amount);
		return account;	
	 }
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteaccount(@PathVariable Long accountNumber){
		accountservice.CloseAccount(accountNumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account_close");
	}
}