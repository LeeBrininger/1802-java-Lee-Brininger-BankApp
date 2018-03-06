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

	
	public static String selectWallet(List<String> wallets, String open, Scanner input) {
		String walletName = "";
		System.out.println("Type 'Exit' to exit");
		for(int i = 0; i < wallets.size(); i++) {
			if(!wallets.get(i).equals(open)) {
				System.out.println(wallets.get(i));
			}
		}
		walletName = input.nextLine();
		if(walletName.toLowerCase().equals("exit")) {
			return "";
		}
		if(!wallets.contains(walletName) || walletName.equals(open)) {
			System.out.println("That is not a valid wallet, please enter an owned wallet:");
			walletName = selectWallet(wallets, open, input);
		}
		return walletName;
	}
	
	public static Wallet selectAnyWallet(Scanner input) {
		HashMap<String, Wallet> allWallets = MemoryHub.getWallets();
		String selectedWallet = "";
		Wallet wallet;
		
		System.out.println("Existing Wallets: (Type exit to exit)");
		for(HashMap.Entry<String, Wallet> acc : allWallets.entrySet()) {
			System.out.println(acc.getKey());
		}
		selectedWallet = input.nextLine();
		if(selectedWallet.toLowerCase().equals("exit")) {
			return null;
		}
		if(allWallets.containsKey(selectedWallet)) {
			wallet = (Wallet) allWallets.get(selectedWallet);
			return wallet;
		}else {
			System.out.println("Please enter a valid wallet");
			wallet = selectAnyWallet(input);
		}
		return wallet;
	}
	
	public static Wallet selectNonActiveWallet(Customer active, Scanner input) {
		HashMap<String, Wallet> allWallets = MemoryHub.getWallets();
		String selectedWallet = "";
		Wallet wallet;
		
		System.out.println("Existing Wallets: (Type Exit to exit)");
		for(HashMap.Entry<String, Wallet> acc : allWallets.entrySet()) {
			if(!active.getWalletsOwned().contains(acc.getKey())) {
				System.out.println(acc.getKey());
			}
		}
		selectedWallet = input.nextLine();
		if(selectedWallet.toLowerCase().equals("exit")) {
			return null;
		}
		if(allWallets.containsKey(selectedWallet)&& !active.getWalletsOwned().contains(selectedWallet)) {
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
		
		System.out.println("Existing Customers: (Type Exit to exit)");
		for(HashMap.Entry<String, Account> acc : allCustomers.entrySet()) {
			if(acc.getValue() instanceof Customer && acc.getValue().getActive()) {
				System.out.println(acc.getKey());
			}
		}
		selectedCustomer = input.nextLine();
		if(selectedCustomer.toLowerCase().equals("exit")) {
			return null;
		}
		if(allCustomers.containsKey(selectedCustomer) && allCustomers.get(selectedCustomer) instanceof Customer && allCustomers.get(selectedCustomer).getActive()) {
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
		
		System.out.println("Existing Users: (Type Exit to exit)");
		for(HashMap.Entry<String, Account> acc : allCustomers.entrySet()) {
			System.out.println(acc.getKey());
		}
		selectedCustomer = input.nextLine();
		if(selectedCustomer.toLowerCase().equals("exit")) {
			return null;
		}
		if(allCustomers.containsKey(selectedCustomer)) {
			account = allCustomers.get(selectedCustomer);
			return account;
		}else {
			System.out.println("Please enter a valid user");
			account = selectCustomer(input);
		}
		return account;
	}
	
	
	public static void transferFundsAll(Account user, Wallet activeWallet, Scanner input) {
		HashMap<String, Wallet> allWallets = MemoryHub.getWallets();
		String choise = "";
		String selection = "";
		Double money = 0.0;
		String secondName;
		Wallet secondWallet;
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
			selection = input.nextLine();
			if(selection.equals("exit")) {
				transferFundsAll(user, activeWallet, input);
			}
			if(!selection.matches("-?\\d+(\\.\\d+)?")) {
				System.out.println("Needs to be a number");
				transferFundsAll(user, activeWallet, input);
			}
			money = Double.parseDouble(selection);
			if(activeWallet.subtractFunds(money)){
				System.out.println("New ammount: $" + activeWallet.getMoney());
			}else {
				System.out.println("Insufficient funds");
			}
		}
		else if(choise.equals("3")) {
			System.out.println("How much do you want to deposit: ");
			selection = input.nextLine();
			if(selection.equals("exit")) {
				transferFundsAll(user, activeWallet, input);
			}
			if(!selection.matches("-?\\d+(\\.\\d+)?")) {
				System.out.println("Needs to be a number");
				transferFundsAll(user, activeWallet, input);
			}
			money = Double.parseDouble(selection);
			if(activeWallet.addFunds(money)) {
				System.out.println("New ammount: $" + activeWallet.getMoney());
			}else {
				System.out.println("Needs to be positive");
			}
			
		}
		else if(choise.equals("4")) {
			System.out.println("How much do you want to transfer out: ");
			selection = input.nextLine();
			if(selection.equals("exit")) {
				transferFundsAll(user, activeWallet, input);
			}
			if(!selection.matches("-?\\d+(\\.\\d+)?")) {
				System.out.println("Needs to be a number");
				transferFundsAll(user, activeWallet, input);
			}
			money = Double.parseDouble(selection);
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
			return;
		}else {
			System.out.println("Please enter a valid choise");
		}
		transferFundsAll(user, activeWallet, input);
	}
	
}
