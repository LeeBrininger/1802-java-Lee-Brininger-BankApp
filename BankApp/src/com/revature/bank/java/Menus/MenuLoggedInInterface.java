package com.revature.bank.java.Menus;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.revature.bank.java.BankHub;
import com.revature.bank.java.MemoryHub;
import com.revature.bank.java.Users.Account;
import com.revature.bank.java.Users.Admin;
import com.revature.bank.java.Users.Customer;
import com.revature.bank.java.Users.Employee;
import com.revature.bank.java.Users.Wallet;
import com.revature.bank.util.LoggingUtil;

public class MenuLoggedInInterface {

	public static void preformCustomer(Account user, Wallet activeWallet, Scanner input) {
		HashMap<String, Wallet> allWallets = MemoryHub.getWallets();
		Customer customer = (Customer) user;
		List<String> wallets = customer.getWalletsOwned();
		String walletName = "";
		String secondName = "";
		Wallet secondWallet;
		String choise = "";
		double money = 0.0;
		
		MenuInterface.aesthetics();
		System.out.println("Hello " + customer.getFirstName() + " " + customer.getLastName() + "\n");
		
		if(activeWallet == null) {
			System.out.println("Please select the account you want see:\n");
			walletName = selectWallet(wallets, "", input);
			activeWallet = allWallets.get(walletName);
		}
		
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1: Check Balance\n2: Withdraw Funds\n3: Deposit Funds\n4: Transfer Funds\n5: Switch Accounts\n6: Exit");
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
		}
		else if(choise.equals("5")){
			System.out.println("Which account would you like to transfer too?");
			walletName = selectWallet(wallets, activeWallet.getName(), input);
			activeWallet = allWallets.get(walletName);
			preformCustomer(user, activeWallet, input);
			
		}else if(choise.equals("6")){
			MemoryHub.storeData();
			BankHub.commandTree();
		}else {
			System.out.println("Please enter a valid choise");
			preformCustomer(user, activeWallet, input);
		}
		preformCustomer(user, activeWallet, input);
		
	}
	
	public static void preformEmployee(Account user, Scanner input) {
		HashMap<String, Wallet> allWallets = MemoryHub.getWallets();
		Employee employee = (Employee) user;
		String choise = "";
		
		
		MenuInterface.aesthetics();
		System.out.println("Welcome back employee");
		System.out.println("Select you action: ");
		System.out.println("1: View Customers\n2: View accounts\n3: Approve/Deny accounts");
		
		
		
		System.out.println("employee");
		
		
		
	}
	
	public static void preformAdmin(Account user, Scanner input) {
		HashMap<String, Wallet> allWallets = MemoryHub.getWallets();
		Admin customer = (Admin) user;
		MenuInterface.aesthetics();
		System.out.println("admin");
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
}
