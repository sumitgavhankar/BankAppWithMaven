package com.capgemini;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.initializer.AppInitializer;

public class MainBankApp{

	public MainBankApp() {
	}
	public static void main(String[] args) throws Exception {
		  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	        AppInitializer appInitializer = applicationContext.getBean(AppInitializer.class);
	        appInitializer.showMenu();
	}


}
