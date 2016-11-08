package com.capgemini.service;

public class RandomAccountNumberGenerator {
	
	public int generateAccountNumber(){
		double  random = Math.random() * 99999 + 1;
		return (int) random;
		
	}

}
