package com.capgemini.model;

public class Account {
	
	public Account(){
		
	}
	private int accountNumber;
	private int amount;
	Customer customer;
	
	public Account(int accountNumber, int amount, Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.customer= customer;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + amount;
		return result;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", amount=" + amount + ", customer=" + customer + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (amount != other.amount)
			return false;
		return true;
	}
	
	

}
