package com.revature.bank.java.Menus;

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
		int choise = 0;
		double money = 0.0;
		
		MenuInterface.aesthetics();
		System.out.println("Hello " + customer.getFirstName() + " " + customer.getLastName() + "\n");
		
		while(activeWallet == null) {
			System.out.println("Please select the account you want see:\n");
			walletName = AccountWalletFinder.selectWallet(wallets, "", input);
			
			activeWallet = allWallets.get(walletName);
			if(activeWallet == null) {
				System.out.println("Please select an account");
			}
		}
		
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1: Check Balance\n2: Withdraw Funds\n3: Deposit Funds\n4: Transfer Funds\n"
				+ "5: Switch Accounts\n6: Apply For Joint Account\n7: Create New Account\n8: Exit");
		choise = Integer.parseInt(input.nextLine());
		if(choise == 1) {
			System.out.println("Your Current funds are: $" + activeWallet.getMoney() + "0");
		}
		else if(choise == 2) {
			System.out.println("How much do you want to withdraw: ");
			money = Double.parseDouble(input.nextLine());
			if(activeWallet.subtractFunds(money)){
				System.out.println("New ammount: $" + activeWallet.getMoney());
				MemoryHub.storeData();//Save change
			}else {
				System.out.println("Insufficient funds");
			}
		}
		else if(choise == 3) {
			System.out.println("How much do you want to deposit: ");
			money = Double.parseDouble(input.nextLine());
			if(activeWallet.addFunds(money)) {
				System.out.println("New ammount: $" + activeWallet.getMoney());
				MemoryHub.storeData();//Save change
			}else {
				System.out.println("Needs to be positive");
			}
		}
		else if(choise == 4) {
			System.out.println("How much do you want to transfer out: ");
			money = Double.parseDouble(input.nextLine());
			MemoryHub.storeData();
			if(money < 0) {
				System.out.println("Needs to be positive");
			}else {
				System.out.println("Which account do you want to transfer to:");
				secondName = AccountWalletFinder.selectWallet(wallets, activeWallet.getName(), input);
				if(secondName == null) {
					preformCustomer(user, activeWallet, input);
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
		else if(choise == 5){
			System.out.println("Which account would you like to transfer too?");
			walletName = AccountWalletFinder.selectWallet(wallets, activeWallet.getName(), input);
			activeWallet = allWallets.get(walletName);
			MemoryHub.storeData();
		}else if(choise == 6){
			System.out.println("Which account would you like to request joint access too?");
			secondWallet = AccountWalletFinder.selectNonActiveWallet(customer, input);
			if(wallets.contains(secondWallet.getName())) {
				System.out.println("You already have access to that account");
			}else {
				System.out.println("You now have access to this account");
				customer.addWallet(secondWallet.getName());
			}
			MemoryHub.storeData();
		}else if(choise == 7) {
			customer.addWallet(MenuCreateNewAccount.createNewWallet(input).getName());
		}
		else if(choise == 8){
			MemoryHub.storeData();
			BankHub.commandTree();
		}else {
			System.out.println("Please enter a valid choise");
		}
		preformCustomer(user, activeWallet, input);
	}
	
	public static void preformEmployee(Account user, Scanner input) {
		String choise = "";
		Customer viewee;
		Wallet walletee;
		
		MenuInterface.aesthetics();
		System.out.println("Welcome back Employee");
		System.out.println("Select you action: ");
		System.out.println("1: View Customer\n2: View Account\n3: Approve/Deny account\n4: Exit");
		choise = input.nextLine();
		if(choise.equals("1")) {
			viewee = AccountWalletFinder.selectCustomer(input);
			System.out.println("Customer information:");
			viewee.printInfo();
		}else if(choise.equals("2")) {
			walletee = AccountWalletFinder.selectAnyWallet(input);
			System.out.println("Wallet information:");
			walletee.printInfo();
		}else if(choise.equals("3")) {
			MenuApproveAccount.approveAccount(input);
		}else{
			MemoryHub.storeData();
			BankHub.commandTree();
		}
		preformEmployee(user, input);
	}
	
	public static void preformAdmin(Account user, Scanner input) {
		Admin admin= (Admin) user;
		String choise = "";
		String yesorno = "";
		Account viewee;
		Wallet activeWallet;
		
		MenuInterface.aesthetics();
		System.out.println("Welcome back Sir");
		System.out.println("Please select you action: ");
		System.out.println("1: View Customers and Employees\n2: Edit Account\n3: Approve/Deny account\n4: Cancel User\n5: Cancel Account\n6: Exit");
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
		}else if(choise.equals("2")) {
			System.out.println("Please select the account you want see:\n");
			activeWallet = AccountWalletFinder.selectAnyWallet(input);
			AccountWalletFinder.transferFundsAll(user, activeWallet, input);
		}else if(choise.equals("3")) {
			MenuApproveAccount.approveAccount(input);
		}else if(choise.equals("4")) {
			System.out.println("Please select the user that you want to delete");
			viewee = AccountWalletFinder.selectAnyAccount(input);
			if(viewee instanceof Customer || viewee instanceof Employee) {
				System.out.println("User information:");
				viewee.printInfo();
				System.out.println("Are you sure you want to delete this user: (yes or no)");
				yesorno = input.nextLine();
				yesorno.toLowerCase();
				while(yesorno.equals("yes") && yesorno.equals("no")) {
					System.out.println("Please enter a valid response");
				}
				if(yesorno.equals("yes")) {
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
		}else if(choise.equals("5")) {
			System.out.println("Please select the account that you want to delete");
			activeWallet = AccountWalletFinder.selectAnyWallet(input);
			System.out.println("Account information:");
			activeWallet.printInfo();
			System.out.println("Are you sure you want to delete this account: (yes or no)");
			yesorno = input.nextLine();
			yesorno.toLowerCase();
			while(yesorno.equals("yes") && yesorno.equals("no")) {
				System.out.println("Please enter a valid response");
			}
			if(yesorno.equals("yes")) {
				LoggingUtil.logInfo(activeWallet.getName() + " deleted");
				MemoryHub.removeWallet(activeWallet);
				System.out.println("Account deleted");
				MemoryHub.storeData();
			}
			else {
				System.out.println("Account not deleted");
			}
		}else{
			MemoryHub.storeData();
			BankHub.commandTree();
		}
		preformAdmin(admin, input);
	}
}
