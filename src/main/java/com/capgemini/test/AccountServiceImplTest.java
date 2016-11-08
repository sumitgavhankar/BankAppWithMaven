package com.capgemini.test;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.model.Customer;
import com.capgemini.repository.AccountRepository;
import com.capgemini.repository.AccountRepositoryImpl;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class AccountServiceImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}
	
	static AccountRepository accountRepository;
	static AccountService accountService;
	static Customer customer;
	static Account account;
	
	/*
	1. When valid info us passed account should be created
	2. When amount is less than 500, system should throw exception
	3. When account already exists, throw exception
	4. When invalid info is passed, throw exception*/
	
	@BeforeClass
	public static void setUp(){
		accountRepository= new AccountRepositoryImpl();
		accountService= new AccountServiceImpl();
		customer= new Customer("Sumit", "Gavhankar");
		account= new Account(77777,70000,customer);
	}
	
	
	@Test
	public void WhenValidInfoForAccountCreation() throws InvalidAccountNumberException, InsufficientInitialBalanceException{
		Customer customer= new Customer("Sumit", "Gavhankar");
		//when(accountRepository.saveAccount(account)).thenReturn(true);
		assertEquals(account, accountService.createAccount(77777, 70000, customer));
		
	}
	
	@Test(expected=com.capgemini.exceptions.InsufficientInitialBalanceException.class)
	public void whenInitialAmountIsLowThrowException() throws InsufficientInitialBalanceException, InvalidAccountNumberException{
		accountService.createAccount(12345, 400, customer);
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenDuplicateAccountThrowException() throws InvalidAccountNumberException, InsufficientInitialBalanceException{
		assertEquals(account, accountService.createAccount(77777,70000,customer));
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenInvalidAccountInfoThrowException() throws InvalidAccountNumberException, InsufficientInitialBalanceException{
		Customer customer=null;
		assertEquals(account, accountService.createAccount(77777,70000,customer));
	}
	

}
