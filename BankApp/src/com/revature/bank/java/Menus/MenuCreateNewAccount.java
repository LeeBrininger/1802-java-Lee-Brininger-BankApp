package com.revature.bank.java.Menus;

import java.util.Scanner;

import com.revature.bank.java.AccountWalletFinder;
import com.revature.bank.java.BankHub;
import com.revature.bank.java.MemoryHub;
import com.revature.bank.pojo.Customer;
import com.revature.bank.pojo.Wallet;
import com.revature.bank.util.LoggingUtil;

public class MenuCreateNewAccount {  
	
	public static void runCreate(Scanner input) {
		Customer newCust = new Customer();
		int choise = 0;
		String statement = "";
		Wallet newW = null;
		
		System.out.println("Thank You for Choosing the First Bank of Richmond");
		System.out.println("Please follow the prompts below to set up your account.\n");
		System.out.println("Type 'Exit' at any time to cancel account and exit");
		System.out.println("Please Enter your firstname: ");
		statement = input.nextLine();
		if(statement.toLowerCase().equals("exit")) {
			BankHub.commandTree();
		}
		newCust.setFirstName(statement);
		System.out.println("Please Enter your last name: ");
		statement = input.nextLine();
		if(statement.toLowerCase().equals("exit")) {
			BankHub.commandTree();
		}
		newCust.setLastName(statement);
		System.out.println("Please Enter your SSN: ");
		statement = input.nextLine();
		while(!statement.matches("-?\\d+(\\.\\d+)?")) {
			if(statement.equals("exit")) {
				BankHub.commandTree();
			}
			System.out.println("Needs to be a number");
			statement = input.nextLine();
		}
		newCust.setSSN(Integer.parseInt(statement));
		System.out.println("Please Set your Username: ");
		statement = input.nextLine();
		if(statement.toLowerCase().equals("exit")) {
			BankHub.commandTree();
		}
		while(MemoryHub.getAccounts().containsKey(statement)) {
			System.out.println("That username is already taken, please enter a different one");
			statement = input.nextLine();
			if(statement.toLowerCase().equals("exit")) {
				BankHub.commandTree();
			}
		}
		newCust.setUsername(statement);
		System.out.println("Please Set your Password: ");
		statement = input.nextLine();
		if(statement.toLowerCase().equals("exit")) {
			BankHub.commandTree();
		}
		newCust.setPassword(statement);
		System.out.println("Please Enter your e-mail: ");
		statement = input.nextLine();
		if(statement.toLowerCase().equals("exit")) {
			BankHub.commandTree();
		}
		newCust.setEmail(statement);
		System.out.println("\nWould you like to add a new account or access an existing one?\n1: New Account\n2: Access Existing Account");
		statement = input.nextLine();
		if(statement.toLowerCase().equals("exit")) {
			BankHub.commandTree();
		}
		choise = Integer.parseInt(statement);
		switch(choise) {
		case 1:
			newCust.addWallet(createNewWallet(input).getName());
			break;
		case 2:
			newW = AccountWalletFinder.selectAnyWallet(input);
			if(newW == null){
				BankHub.commandTree();
			}
			newCust.addWallet(newW.getName());
			break;
		}
		LoggingUtil.logInfo("");
		System.out.println("Thank you, your account is awaiting approval.");
		newCust.setUnActive();
		MemoryHub.addAccount(newCust);
		//MemoryHub.storeData();
		BankHub.commandTree();
	}
	
	public static Wallet createNewWallet(Scanner input) {
		Wallet newWallet = new Wallet();
		String response;
		double moneyR = 0;
		System.out.println("Please enter the type of account(checking/savings):");
		response = input.nextLine();
		response.toLowerCase();
		while(!response.equals("checking") && !response.equals("savings")) {
			if(response.equals("exit")) {
				BankHub.commandTree();
			}
			System.out.println("Please enter either checking or savings");
			response = input.nextLine();
			response.toLowerCase();
		}
		newWallet.setType(response);
		System.out.println("Please enter a unique name for you account: ");
		response = input.nextLine();
		if(response.toLowerCase().equals("exit")) {
			BankHub.commandTree();
		}
		while(MemoryHub.getWallets().containsKey(response)) {
			if(response.toLowerCase().equals("exit")) {
				BankHub.commandTree();
			}
			System.out.println("That account name is taken, please try again:");
			response = input.nextLine();
		}
		newWallet.setName(response);
		System.out.println("Please deposit your inital funds(minimum of $50):");
		response = input.nextLine();
		while(!response.matches("-?\\d+(\\.\\d+)?")) {
			if(response.toLowerCase().equals("exit")) {
				BankHub.commandTree();
			}
			System.out.println("Needs to be a number");
			response = input.nextLine();
		}
		moneyR = Double.parseDouble(response);
		while(moneyR < 50.0) {
			System.out.println("Thats not enough, please enter a proper ammount:");
			moneyR = Double.parseDouble(input.nextLine());
			if(response.toLowerCase().equals("exit")) {
				BankHub.commandTree();
			}
		}
		newWallet.addFunds(moneyR);
		LoggingUtil.logInfo(newWallet.getInfo());
		MemoryHub.addWallet(newWallet);
		return newWallet;
	}
}
