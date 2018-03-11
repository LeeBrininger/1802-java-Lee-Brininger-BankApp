package com.revature.bank.java.Menus;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.revature.bank.java.AccountWalletFinder;
import com.revature.bank.java.MemoryHub;
import com.revature.bank.java.Users.Account;
import com.revature.bank.java.Users.Customer;
import com.revature.bank.java.Users.Wallet;

public class MenuMoneyTransfers {
	
	public static void withdrawMoney(Account user, Wallet activeWallet, Scanner input) {
		String selection = "";
		double money = 0;
	
		System.out.println("How much do you want to withdraw: ");
		selection = input.nextLine();
		if(selection.equals("exit")) {
			return;
		}
		if(!selection.matches("-?\\d+(\\.\\d+)?")) {
			System.out.println("Needs to be a number");
			return;
		}
		money = Double.parseDouble(selection);
		System.out.println(money);
		if(activeWallet.subtractFunds(money)){
			System.out.println("New ammount: $" + activeWallet.getMoney());
			MemoryHub.storeData();//Save change
		}else {
			System.out.println("Insufficient funds");
		}
	}
	
	public static void addMoney(Account user, Wallet activeWallet, Scanner input) {
		String selection = "";
		double money = 0;
		
		System.out.println("How much do you want to deposit: ");
		selection = input.nextLine();
		if(selection.equals("exit")) {
			return;
		}
		if(!selection.matches("-?\\d+(\\.\\d+)?")) {
			System.out.println("Needs to be a number");
			return;
		}
		money = Double.parseDouble(selection);
		if(activeWallet.addFunds(money)) {
			System.out.println("New ammount: $" + activeWallet.getMoney());
			MemoryHub.storeData();//Save change
		}else {
			System.out.println("Needs to be positive");
		}
	}
	
	public static void transferMoneyBetweenAccounts(Customer customer, List<String> wallets, Wallet activeWallet, Scanner input) {
		HashMap<String, Wallet> allWallets = MemoryHub.getWallets();
		String selection = "";
		double money = 0;
		String secondName = "";
		Wallet secondWallet;
		
		System.out.println("How much do you want to transfer out: ");
		selection = input.nextLine();
		if(selection.equals("exit")) {
			return;
		}
		if(!selection.matches("-?\\d+(\\.\\d+)?")) {
			System.out.println("Needs to be a number");
			transferMoneyBetweenAccounts(customer, wallets, activeWallet, input);
			return;
		}
		money = Double.parseDouble(selection);
		MemoryHub.storeData();
		if(money < 0) {
			System.out.println("Needs to be positive");
		}else {
			System.out.println("Which account do you want to transfer to:");
			secondName = AccountWalletFinder.selectWallet(customer, wallets, activeWallet.getName(), input);
			if(secondName == null) {
				return;
			}
			secondWallet = allWallets.get(secondName);
			if(activeWallet.subtractFunds(money)) {
				secondWallet.addFunds(money);
				System.out.println("New ammount in " + activeWallet.getName() + ": $" + activeWallet.getMoney());
				System.out.println("New ammount in " + secondWallet.getName() + ": $" + secondWallet.getMoney());
				MemoryHub.storeData();//Save change
			}else {
				System.out.println("Insufficient funds");
			}
		}
	}
}
