package com.revature.bank.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.revature.bank.java.Menus.MenuLoggedInInterface;
import com.revature.bank.java.Users.Account;
import com.revature.bank.java.Users.Customer;
import com.revature.bank.java.Users.Wallet;

public class AccountWalletFinder {

	public static Wallet selectAnyWallet(Scanner input) {
		HashMap<String, Wallet> allWallets = MemoryHub.getWallets();
		String selectedWallet = "";
		Wallet wallet;
		
		System.out.println("Existing Wallets:\n");
		for(HashMap.Entry<String, Wallet> acc : allWallets.entrySet()) {
			System.out.println(acc.getKey());
		}
		selectedWallet = input.nextLine();
		if(allWallets.containsKey(selectedWallet)) {
			wallet = (Wallet) allWallets.get(selectedWallet);
			return wallet;
		}else {
			System.out.println("Please enter a valid wallet");
			wallet = selectAnyWallet(input);
		}
		return wallet;
	}
	
	
	
	public static Customer selectCustomer(Scanner input) {
		HashMap<String, Account> allCustomers = MemoryHub.getAccounts();
		String selectedCustomer = "";
		Customer customer;
		
		System.out.println("Existing Customers:\n");
		for(HashMap.Entry<String, Account> acc : allCustomers.entrySet()) {
			if(acc.getValue() instanceof Customer) {
				System.out.println(acc.getKey());
			}
		}
		selectedCustomer = input.nextLine();
		if(allCustomers.containsKey(selectedCustomer) && allCustomers.get(selectedCustomer) instanceof Customer) {
			customer = (Customer) allCustomers.get(selectedCustomer);
			return customer;
		}else {
			System.out.println("Please enter a valid customer");
			customer = selectCustomer(input);
		}
		return customer;
	}
	
	public static Account selectAnyAccount(Scanner input) {
		HashMap<String, Account> allCustomers = MemoryHub.getAccounts();
		String selectedCustomer = "";
		Account account;
		
		System.out.println("Existing Users:\n");
		for(HashMap.Entry<String, Account> acc : allCustomers.entrySet()) {
			System.out.println(acc.getKey());
		}
		selectedCustomer = input.nextLine();
		if(allCustomers.containsKey(selectedCustomer)) {
			account = allCustomers.get(selectedCustomer);
			return account;
		}else {
			System.out.println("Please enter a valid user");
			account = selectCustomer(input);
		}
		return account;
	}
	
	public static String selectWallet(List<String> wallets, String open, Scanner input) {
		String walletName = "";
		
		while(!wallets.contains(walletName) || walletName.equals(open)) {
			for(int i = 0; i < wallets.size(); i++) {
				if(!wallets.get(i).equals(open)) {
					//LoggingUtil.logDebug("." + wallets.get(i) + " . " + open);
					System.out.println(wallets.get(i));
				}
			}
			walletName = input.nextLine();
			if(!wallets.contains(walletName) || walletName.equals(open)) {
				System.out.println("That is not a valid wallet, please enter an owned wallet:");
			}
		}
		return walletName;
	}
	
	
	
	public static void transferFundsAll(Account user, Wallet activeWallet, Scanner input) {
		HashMap<String, Wallet> allWallets = MemoryHub.getWallets();
		String choise = "";
		Double money = 0.0;
		String secondName;
		Wallet secondWallet;
		
		@SuppressWarnings("unchecked")
		List<String> wallets = new ArrayList<String>(MemoryHub.getWallets().keySet());
		
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1: Check Balance\n2: Withdraw Funds\n3: Deposit Funds\n4: Transfer Funds\n5: Leave Account");
		choise = input.nextLine();
		if(choise.equals("1")) {
			System.out.println("Your Current funds are: $" + activeWallet.getMoney() + "0");
		}
		else if(choise.equals("2")) {
			System.out.println("How much do you want to withdraw: ");
			money = Double.parseDouble(input.nextLine());
			if(activeWallet.subtractFunds(money)){
				System.out.println("New ammount: $" + activeWallet.getMoney());
			}else {
				System.out.println("Insufficient funds");
			}
		}
		else if(choise.equals("3")) {
			System.out.println("How much do you want to deposit: ");
			money = Double.parseDouble(input.nextLine());
			if(activeWallet.addFunds(money)) {
				System.out.println("New ammount: $" + activeWallet.getMoney());
			}else {
				System.out.println("Needs to be positive");
			}
			
		}
		else if(choise.equals("4")) {
			System.out.println("How much do you want to transfer out: ");
			money = Double.parseDouble(input.nextLine());
			if(money < 0) {
				System.out.println("Needs to be positive");
			}else {
				System.out.println("Which account do you want to transfer to:");
				secondName = selectWallet(wallets, activeWallet.getName(), input);
				secondWallet = allWallets.get(secondName);
				if(activeWallet.subtractFunds(money)) {
					secondWallet.addFunds(money);
					System.out.println("New ammount in " + activeWallet.getName() + ": $" + activeWallet.getMoney());
					System.out.println("New ammount in " + secondWallet.getName() + ": $" + secondWallet.getMoney());
				}else {
					System.out.println("Insufficient funds");
				}
			}
		}else if(choise.equals("5")){
			MemoryHub.storeData();
			MenuLoggedInInterface.preformAdmin(user, input);
		}else {
			System.out.println("Please enter a valid choise");
			transferFundsAll(user, activeWallet, input);
		}
		transferFundsAll(user, activeWallet, input);
	}
	
}
