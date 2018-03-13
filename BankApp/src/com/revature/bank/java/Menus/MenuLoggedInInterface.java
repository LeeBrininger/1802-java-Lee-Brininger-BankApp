  package com.revature.bank.java.Menus;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.revature.bank.java.AccountWalletDelete;
import com.revature.bank.java.AccountWalletFinder;
import com.revature.bank.java.BankHub;
import com.revature.bank.java.MemoryHub;
import com.revature.bank.pojo.Account;
import com.revature.bank.pojo.Admin;
import com.revature.bank.pojo.Customer;
import com.revature.bank.pojo.Employee;
import com.revature.bank.pojo.Wallet;
import com.revature.bank.util.LoggingUtil;

public class MenuLoggedInInterface {

	public static void preformCustomer(Account user, Wallet activeWallet, Scanner input) {
		HashMap<String, Wallet> allWallets = MemoryHub.getWallets();
		Customer customer = (Customer) user;
		List<String> wallets = MemoryHub.getCustomerWallets(user);
		String walletName = "";
		Wallet secondWallet;
		String selection = "";
		int choise = 0;

		MenuInterface.aesthetics();
		System.out.println("Hello " + customer.getFirstName() + " " + customer.getLastName() + "\n");
		///////////////////////////////MenuApproveAccount.checkIfAccountRequested(customer, input);
		
		System.out.println(allWallets.size());
		
		while(activeWallet == null) {
			walletName = AccountWalletFinder.selectWallet(customer, wallets, "", input);
			if(walletName.equals("")) {
				BankHub.commandTree(); 
			}
			activeWallet = allWallets.get(walletName);
			if(activeWallet == null) {
				System.out.println("Please select a valid account");
			}
		}
		
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1: Check Balance\n2: Withdraw Funds\n3: Deposit Funds\n4: Transfer Funds\n"
				+ "5: Switch Accounts\n6: Apply For Joint Account\n7: Create New Account\n8: Exit");
		selection = input.nextLine();
		while(!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4") && !selection.equals("5") && !selection.equals("6") && !selection.equals("7") && !selection.equals("8")) {
			System.out.println("Please enter a valid input");
			selection = input.nextLine();
		}
		choise = Integer.parseInt(selection);
		switch(choise) {
		case 1:
			System.out.println("Your Current funds are: $" + activeWallet.getMoney() + "0");
			break;
		case 2:
			MenuMoneyTransfers.withdrawMoney(user, activeWallet, input);
			break;
		case 3:
			MenuMoneyTransfers.addMoney(user, activeWallet, input);
			break;
		case 4:
			MenuMoneyTransfers.transferMoneyBetweenAccounts(customer, wallets, activeWallet, input);
		case 5:
			System.out.println("Which account would you like to transfer too?");
			walletName = AccountWalletFinder.selectWallet(customer, wallets, activeWallet.getName(), input);
			if(!walletName.equals("")) {
				activeWallet = allWallets.get(walletName);
				//MemoryHub.storeData();
			}
			break;
		case 6:
			System.out.println("Which account would you like to request joint access too?");
			secondWallet = AccountWalletFinder.selectNonActiveWallet(customer, input);
			if(secondWallet == null) {
				System.out.println("No account joined");
			}
			else if(wallets.contains(secondWallet.getName())) {
				System.out.println("You already have access to that account");
			}else {
				secondWallet.setRequested(customer);
				System.out.println("The request has been sent to the accound owners for approval");
				LoggingUtil.logInfo(customer.getUsername() + " requested access to account " + secondWallet);
			}
			break;
		case 7:
			customer.addWallet(MenuCreateNewAccount.createNewWallet(input).getName());
			break;
		case 8:
			LoggingUtil.logInfo(customer.getUsername() + " logged out");
			BankHub.commandTree();
			break;
		default:
			System.out.println("Please enter a valid choise");
		}
		preformCustomer(user, activeWallet, input);
	}
	
	public static void preformEmployee(Account user, Scanner input) {
		int choise = 0;
		Customer viewee;
		Wallet walletee;
		String selection = "";
		
		MenuInterface.aesthetics();
		System.out.println("Welcome back Employee");
		System.out.println("Select you action: ");
		System.out.println("1: View Customer\n2: View Account\n3: Approve/Deny account\n4: Exit");
		selection = input.nextLine();
		while(!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4")) {
			System.out.println("Please enter a valid input");
			selection = input.nextLine();
		}
		choise = Integer.parseInt(selection);
		switch(choise) {
		case 1:
			viewee = AccountWalletFinder.selectCustomer(input);
			if(viewee == null) {
				preformEmployee(user, input);
			}
			System.out.println("Customer information:");
			viewee.printInfo();
			break;
		case 2:
			walletee = AccountWalletFinder.selectAnyWallet(input);
			if(walletee == null) {
				preformEmployee(user, input);
			}
			System.out.println("Account information:");
			walletee.printInfo();
			break;
		case 3:
			MenuApproveAccount.approveAccount(input);
		default:
			LoggingUtil.logInfo(user.getUsername() + " logged out");
			//MemoryHub.storeData();
			BankHub.commandTree();
		}
		preformEmployee(user, input);
	}
	
	public static void preformAdmin(Account user, Scanner input) {
		Admin admin= (Admin) user;
		int choise = 0;
		Account viewee;
		Wallet activeWallet;
		String selection = "";
		
		MenuInterface.aesthetics();
		System.out.println("Welcome back Sir");
		System.out.println("Please select you action: ");
		System.out.println("1: View Customers and Employees\n2: Edit Account\n3: Approve/Deny account\n4: Cancel User\n5: Cancel Account\n6: Exit");
		selection = input.nextLine();
		while(!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4") && !selection.equals("5") && !selection.equals("6")) {
			System.out.println("Please enter a valid input");
			selection = input.nextLine();
		}
		choise = Integer.parseInt(selection);
		switch(choise) {
		case 1:
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
			break;
		case 2:
			System.out.println("Please select the account you want see:\n");
			activeWallet = AccountWalletFinder.selectAnyWallet(input);
			if(activeWallet == null) {
				preformAdmin(admin, input);
			}
			AccountWalletFinder.transferFundsAll(user, activeWallet, input);
			break;
		case 3:
			MenuApproveAccount.approveAccount(input);
			break;
		case 4:
			AccountWalletDelete.deleteUser(input);
			break;
		case 5:
			AccountWalletDelete.deleteWallet(input);
			break;
		default:
			LoggingUtil.logInfo(admin.getUsername() + " logged out");
			//MemoryHub.storeData();
			BankHub.commandTree();
		}
		preformAdmin(admin, input);
	}
}
