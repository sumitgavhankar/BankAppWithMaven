package com.capgemini.repository;

import java.util.Set;

import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;

public interface AccountRepository {

	Account searchAccount(int accountNumber) throws InvalidAccountNumberException;

	void saveAccount(Account account);

	void updateAccount(Account updatedAccount);
	
	Set<Account> findAllAccounts();

}