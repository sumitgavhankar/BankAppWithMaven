package com.capgemini;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidAmountForTransactionException;
import com.capgemini.model.Account;
import com.capgemini.model.Customer;
import com.capgemini.repository.AccountRepository;
import com.capgemini.repository.AccountRepositoryImpl;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class AccountCreationTest {

	static AccountRepository accountRepository;
	static AccountService accountService;
	static Customer customer;
	static Account account;
	static Account account2;
	
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
		account2= new Account(99999,90000,customer);
		accountRepository.saveAccount(account);
		accountRepository.saveAccount(account2);
	}
	
	
	@Test
	public void WhenValidInfoForAccountCreation() throws InvalidAccountNumberException, InsufficientInitialBalanceException{
		Customer customer= new Customer("Sumit", "Gavhankar");
		//when(accountRepository.saveAccount(account)).thenReturn(true);
		Account account= new Account(111111, 70000, customer);
		assertEquals(account, accountService.createAccount(111111, 70000, customer));
		
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void WhenDuplicateAccount() throws InvalidAccountNumberException, InsufficientInitialBalanceException{
		Customer customer= new Customer("Sumit", "Gavhankar");
		//when(accountRepository.saveAccount(account)).thenReturn(true);
		assertEquals(account, accountService.createAccount(77777,70000, customer));
		
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
	
	@Test
	public void WhenDepositAmountIsValid() throws InvalidAccountNumberException, InvalidAmountForTransactionException{
		assertEquals(140000, accountService.depositAmount(77777, 70000));
	}
	
	
	@Test(expected=com.capgemini.exceptions.InvalidAmountForTransactionException.class)
	public void whenDepositAmountIsNegativeThrowException() throws InvalidAmountForTransactionException, InvalidAccountNumberException{
		accountService.depositAmount(77777, -104);
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAmountForTransactionException.class)
	public void whenDepositAmountIsZeroThrowException() throws InvalidAmountForTransactionException, InvalidAccountNumberException{
		accountService.depositAmount(77777, 0);
	}
	
	@Test
	public void WhenWithdrawAmountIsValid() throws InvalidAccountNumberException, InvalidAmountForTransactionException, InsufficientBalanceException{
		assertEquals(130000, accountService.withdrawAmount(77777, 10000));
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAmountForTransactionException.class)
	public void whenWithdrawAmountIsNegativeThrowException() throws InvalidAmountForTransactionException, InvalidAccountNumberException, InsufficientBalanceException{
		accountService.withdrawAmount(77777, -104);
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAmountForTransactionException.class)
	public void whenWithdrawAmountIsZeroThrowException() throws InvalidAmountForTransactionException, InvalidAccountNumberException, InsufficientInitialBalanceException, InsufficientBalanceException{
		accountService.withdrawAmount(77777, 0);
	}
	
	@Test(expected=com.capgemini.exceptions.InsufficientBalanceException.class)
	public void whenWithdrawAmountIsHigherThanSoruceAccountforFundTx() throws InvalidAmountForTransactionException, InvalidAccountNumberException, InsufficientBalanceException{
		accountService.fundTransfer(77777, 99999, 10000000);
	}
	@Test(expected=com.capgemini.exceptions.InvalidAmountForTransactionException.class)
	public void whenTransferAmountIsNegativeforFundTx() throws InvalidAmountForTransactionException, InvalidAccountNumberException, InsufficientBalanceException{
		accountService.fundTransfer(77777, 99999, -100);
	}
	@Test(expected=com.capgemini.exceptions.InvalidAmountForTransactionException.class)
	public void whenTransferAmountIsZeroforFundTx() throws InvalidAmountForTransactionException, InvalidAccountNumberException, InsufficientBalanceException{
		accountService.fundTransfer(77777, 99999, 0);
	}
	
	@Test
	public void ShowBalanceforValidAccount() throws InvalidAccountNumberException, InsufficientInitialBalanceException{
		assertEquals(70000, accountService.showBalance(111111));
	}
	
	
	
	
	
	
	

}
