package com.revature.bank.java.Menus;

import java.util.Scanner;

import com.revature.bank.java.AccountWalletFinder;
import com.revature.bank.java.BankHub;
import com.revature.bank.java.MemoryHub;
import com.revature.bank.java.Users.Customer;
import com.revature.bank.java.Users.Wallet;
import com.revature.bank.util.LoggingUtil;

public class MenuCreateNewAccount {  
	
	public static void runCreate(Scanner input) {
		Customer newCust = new Customer();
		int choise = 0;
		
		System.out.println("Thank You for Choosing the First Bank of Richmond");
		System.out.println("Please follow the prompts below to set up your account.\n");
		System.out.println("Please Enter your firstname: ");
		newCust.setFirstName(input.nextLine());
		System.out.println("Please Enter your last name: ");
		newCust.setLastName(input.nextLine());
		System.out.println("Please Enter your SSN: ");
		newCust.setSSN(Integer.parseInt(input.nextLine()));
		System.out.println("Please Set your Username: ");
		newCust.setUsername(input.nextLine());
		System.out.println("Please Set your Password: ");
		newCust.setPassword(input.nextLine());
		System.out.println("Please Enter your e-mail: ");
		newCust.setEmail(input.nextLine());
		System.out.println("\nWould you like to add a new account or access an existing one?\n1: New Acount\n2: Access Existing Account");
		choise = Integer.parseInt(input.nextLine());
		switch(choise) {
		case 1:
			newCust.addWallet(createNewWallet(input).getName());
			break;
		case 2:
			newCust.addWallet(AccountWalletFinder.selectAnyWallet(input).getName());
			break;
		}
		LoggingUtil.logInfo("");
		System.out.println("Thank you, your account is awaiting approval.");
		newCust.setUnActive();
		MemoryHub.addAccount(newCust);
		MemoryHub.storeData();
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
			System.out.println("Please enter either checking or savings");
			response = input.nextLine();
			response.toLowerCase();
		}
		newWallet.setType(response);
		System.out.println("Please enter a unique name for you account: ");
		response = input.nextLine();
		while(MemoryHub.getWallets().containsKey("response")) {
			System.out.println("That account name is taken, please try again:");
			response = input.nextLine();
		}
		newWallet.setName(response);
		System.out.println("Please deposit your inital funds(minimum of $50):");
		moneyR = Double.parseDouble(input.nextLine());
		while(moneyR < 50.0) {
			System.out.println("Thats not enough, please enter a proper ammount:");
			moneyR = Double.parseDouble(input.nextLine());
		}
		newWallet.addFunds(moneyR);
		MemoryHub.addWallet(newWallet);
		return newWallet;
	}
}
