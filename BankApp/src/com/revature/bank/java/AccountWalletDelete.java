package com.revature.bank.java;

import java.util.HashMap;
import java.util.Scanner;

import com.revature.bank.java.Users.Account;
import com.revature.bank.java.Users.Customer;
import com.revature.bank.java.Users.Employee;
import com.revature.bank.java.Users.Wallet;
import com.revature.bank.util.LoggingUtil;

public class AccountWalletDelete {
	public static void deleteUser(Scanner input) {
		Account viewee;
		String response = "";
		System.out.println("Please select the user that you want to delete");
		viewee = AccountWalletFinder.selectAnyAccount(input);
		if(viewee == null) {
			return;
		}
		if(viewee instanceof Customer || viewee instanceof Employee) {
			System.out.println("User information:");
			viewee.printInfo();
			System.out.println("Are you sure you want to delete this user: (yes or no)");
			response = input.nextLine();
			response.toLowerCase();
			while(response.equals("yes") && response.equals("no")) {
				System.out.println("Please enter a valid response");
			}
			if(response.equals("yes")) {
				LoggingUtil.logInfo(viewee.getUsername() + " deleted");
				MemoryHub.removeAccount(viewee);
				System.out.println("User deleted");
				MemoryHub.storeData();
			}
			else {
				System.out.println("user not deleted");
			}
		}else {
			System.out.println("Admins cannot be deleted");
		}
	}
	
	public static void deleteWallet(Scanner input) {
		Wallet activeWallet;
		String response = "";
		Customer check;
		
		System.out.println("Please select the account that you want to delete");
		activeWallet = AccountWalletFinder.selectAnyWallet(input);
		if(activeWallet == null) {
			return;
		}
		System.out.println("Account information:");
		activeWallet.printInfo();
		System.out.println("Are you sure you want to delete this account: (yes or no)");
		response = input.nextLine();
		response.toLowerCase();
		while(response.equals("yes") && response.equals("no")) {
			System.out.println("Please enter a valid response");
		}
		if(response.equals("yes")) {
			LoggingUtil.logInfo(activeWallet.getName() + " deleted");
			for(HashMap.Entry<String, Account> acc : MemoryHub.getAccounts().entrySet()) {
				if(acc.getValue() instanceof Customer) {
					check = (Customer) acc.getValue();
					if(check.getWalletsOwned().contains(activeWallet.getName())) {
						check.removeWallet(activeWallet.getName());
					}
				}
			}
			MemoryHub.removeWallet(activeWallet);
			System.out.println("Account deleted");
			MemoryHub.storeData();
		}
		else {
			System.out.println("Account not deleted");
		}
	}
}
