package com.test.Bank.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long Account_number;
	public String Account_holder_name;
	public double Account_balance;
	public Long getAccount_number() {
		return Account_number;
	}
	public void setAccount_number(Long account_number) {
		Account_number = account_number;
	}
	public String getAccount_holder_name() {
		return Account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		Account_holder_name = account_holder_name;
	}
	public double getAccount_balance() {
		return Account_balance;
	}
	public void setAccount_balance(double account_balance) {
		Account_balance = account_balance;
	}
	public Account(Long account_number, String account_holder_name, double account_balance) {
		super();
		Account_holder_name = account_holder_name;
		Account_balance = account_balance;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [Account_number=" + Account_number + ", Account_holder_name=" + Account_holder_name
				+ ", Account_balance=" + Account_balance + "]";
	}
	
	
	
	
	
}
