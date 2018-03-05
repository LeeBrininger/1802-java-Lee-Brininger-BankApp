package com.revature.bank.java.Menus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.revature.bank.java.AccountWalletFinder;
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
			walletName = AccountWalletFinder.selectWallet(wallets, "", input);
			activeWallet = allWallets.get(walletName);
		}
		
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1: Check Balance\n2: Withdraw Funds\n3: Deposit Funds\n4: Transfer Funds\n"
				+ "5: Switch Accounts\n6: Apply For Joint Account\n7: Exit");
		choise = input.nextLine();
		if(choise.equals("1")) {
			System.out.println("Your Current funds are: $" + activeWallet.getMoney() + "0");
		}
		else if(choise.equals("2")) {
			System.out.println("How much do you want to withdraw: ");
			money = Double.parseDouble(input.nextLine());
			if(activeWallet.subtractFunds(money)){
				System.out.println("New ammount: $" + activeWallet.getMoney());
				MemoryHub.storeData();//Save change
			}else {
				System.out.println("Insufficient funds");
			}
		}
		else if(choise.equals("3")) {
			System.out.println("How much do you want to deposit: ");
			money = Double.parseDouble(input.nextLine());
			if(activeWallet.addFunds(money)) {
				System.out.println("New ammount: $" + activeWallet.getMoney());
				MemoryHub.storeData();//Save change
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
				secondName = AccountWalletFinder.selectWallet(wallets, activeWallet.getName(), input);
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
		else if(choise.equals("5")){
			System.out.println("Which account would you like to transfer too?");
			walletName = AccountWalletFinder.selectWallet(wallets, activeWallet.getName(), input);
			activeWallet = allWallets.get(walletName);
			preformCustomer(user, activeWallet, input);
			
		}else if(choise.equals("6")){
			System.out.println("Which account would you like to request joint access too?");
			secondWallet = AccountWalletFinder.selectAnyWallet(input);
			if(wallets.contains(secondWallet.getName())) {
				System.out.println("You already have access to that account");
			}else {
				System.out.println("Request is logged and awaiting apprival");
			}
		}else if(choise.equals("7")){
			MemoryHub.storeData();
			BankHub.commandTree();
		}else {
			System.out.println("Please enter a valid choise");
			preformCustomer(user, activeWallet, input);
		}
		preformCustomer(user, activeWallet, input);
	}
	
	public static void preformEmployee(Account user, Scanner input) {
		Employee employee = (Employee) user;
		String choise = "";
		Customer viewee;
		Wallet walletee;
		
		
		MenuInterface.aesthetics();
		System.out.println("Welcome back Employee");
		System.out.println("Select you action: ");
		System.out.println("1: View Customer\n2: View Account\n3: Approve/Deny account");
		choise = input.nextLine();
		if(choise.equals("1")) {
			viewee = AccountWalletFinder.selectCustomer(input);
			System.out.println("Customer information:");
			viewee.printInfo();
			preformEmployee(user, input);
		}else if(choise.equals("2")) {
			walletee = AccountWalletFinder.selectAnyWallet(input);
			System.out.println("Wallet information:");
			walletee.printInfo();
			preformEmployee(user, input);
		}else if(choise.equals("3")) {
			System.out.println("ToDo");
		}
	}
	
	public static void preformAdmin(Account user, Scanner input) {
		HashMap<String, Wallet> allWallets = MemoryHub.getWallets();
		Admin admin= (Admin) user;
		String choise = "";
		Account viewee;
		Wallet activeWallet;
		
		MenuInterface.aesthetics();
		System.out.println("Welcome back Sir");
		System.out.println("Please select you action: ");
		System.out.println("1: View Customers and Employees\n2: Edit Account\n3: Approve/Deny account");
		choise = input.nextLine();
		if(choise.equals("1")) {
			viewee = AccountWalletFinder.selectAnyAccount(input);
			if(viewee instanceof Customer) {
				System.out.println("Customer information:");
				viewee.printInfo();
			}else if(viewee instanceof Employee) {
				System.out.println("Employee information:");
				viewee.printInfo();
			}else if(viewee instanceof Admin) {
				System.out.println("Admin information:");
				viewee.printInfo();
			}
			preformAdmin(admin, input);
		}else if(choise.equals("2")) {
			System.out.println("Please select the account you want see:\n");
			activeWallet = AccountWalletFinder.selectAnyWallet(input);
			AccountWalletFinder.transferFundsAll(user, activeWallet, input);
			preformAdmin(admin, input);
		}else if(choise.equals("3")) {
			System.out.println("ToDo");
		}
	}
	
	
}
