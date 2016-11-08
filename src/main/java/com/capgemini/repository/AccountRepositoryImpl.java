package com.capgemini.repository;

import java.util.HashSet;
import java.util.Set;

import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.model.Customer;

public class AccountRepositoryImpl implements AccountRepository {

	public AccountRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	static Set <Account> accounts= new HashSet<Account>();
	
	public static Set<Account> getAccounts() {
		return accounts;
	}
	public static void setAccounts(Set<Account> accounts) {
		AccountRepositoryImpl.accounts = accounts;
	}
	
	public Set<Account> findAllAccounts(){
		Customer customer1= new Customer("Sumit", "capgemini");
		Customer customer2= new Customer("Guddu", "Kumarr");
		accounts.add(new Account(1111,50000,customer1));
		accounts.add(new Account(2222,40000,customer2));
		return accounts;
	}
/* (non-Javadoc)
 * @see com.capgemini.repository.AccountRepository#searchAccount(int)
 */

public Account searchAccount(int accountNumber) throws InvalidAccountNumberException{
	Account searchedAccount=null;
	for (Account account : accounts) {
		if(account!=null){
			if(accountNumber==account.getAccountNumber())
				searchedAccount=account;
		}		
		else
			 throw new InvalidAccountNumberException("Account number is invalid...");
	}
	
	return searchedAccount; 
}

/* (non-Javadoc)
 * @see com.capgemini.repository.AccountRepository#saveAccount(com.capgemini.model.Account)
 */

public void saveAccount(Account account){
	if(account!=null)
		accounts.add(account);
}

/* (non-Javadoc)
 * @see com.capgemini.repository.AccountRepository#updateAccount(com.capgemini.model.Account)
 */

public void updateAccount(Account updatedAccount){
	for (Account account : accounts) {
		
		if(account.getAccountNumber()==updatedAccount.getAccountNumber())
			account.setAmount(updatedAccount.getAmount());
	}
	System.out.println("Account updated successfully: "+updatedAccount.getAccountNumber());
}



	
}
