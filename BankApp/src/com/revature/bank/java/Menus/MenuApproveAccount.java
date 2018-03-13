 package com.revature.bank.java.Menus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.revature.bank.java.MemoryHub;
import com.revature.bank.pojo.Account;
import com.revature.bank.pojo.Customer;
import com.revature.bank.pojo.Wallet;

public class MenuApproveAccount {
	
	
	
	public static void checkIfAccountRequested(Customer customer, Scanner input) {
		
		Map<String, Wallet> allWallets= MemoryHub.getWallets();
		List<String> walletName = customer.getWalletsOwned();
		Wallet found = null;
		String response = "";
		
		
		for(int i = 0; i < walletName.size(); i++) {
			found = allWallets.get(walletName.get(i));
			if(found.getRequested() != null){
				break;
			}
		}
		if(found.getRequested() == null) {
			return;
		}
		System.out.println("User " + found.getRequested().getUsername() + " has requested access to account " + found.getName());
		while(!response.equals("accept") && !response.equals("deny")) {
			System.out.println("Would you like to accept or deny access? (enter exit to skip)");
			response = input.nextLine();
			if(response.equals("exit")) {
				return;
			}else if(response.equals("accept")) {
				found.confirmRequested();
			}else if(response.equals("deny")) {
				found.denyRequested();
			}else {
				System.out.println("Please input a valid response");
			}
		}
	}
	

	public static void approveAccount(Scanner input) {
		Customer customer;
		String selection = "";
		System.out.println("Please select the applied user you want to view:");
		System.out.println("Type 'Exit' to exit");
		customer = selectApprovalNeededCustomer(input);
		if(customer == null) {
			return;
		}
		System.out.println("Here is ther account information:");
		customer.printInfo();
		System.out.println("Would you like to accept or deny this account?");
		selection = input.nextLine();
		while(!selection.equals("accept") && !selection.equals("deny")) {
			System.out.println("Please enter a valid option");
			selection = input.nextLine();
		}
		selection.toLowerCase();
		if(selection.equals("accept")) {
			MemoryHub.swapToActiveAccount(customer);
			System.out.println("Account approved");
		}else if(selection.equals("deny")) {
			MemoryHub.removeAccount(customer);
			System.out.println("Account denied");
		}
		return;
	}
	
	
	private static Customer selectApprovalNeededCustomer(Scanner input) {
		HashMap<String, Account> allCustomers = MemoryHub.getAccounts();
		String selectedCustomer = "";
		Customer customer;
		
		System.out.println("Customers waiting for approval:");
		for(HashMap.Entry<String, Account> acc : allCustomers.entrySet()) {
			if(acc.getValue() instanceof Customer && acc.getValue().getActive() == 0) {
				System.out.println(acc.getKey());
			}
		}
		selectedCustomer = input.nextLine();
		if(selectedCustomer.toLowerCase().equals("exit")) {
			return null;
		}
		if(allCustomers.containsKey(selectedCustomer) && allCustomers.get(selectedCustomer) instanceof Customer && allCustomers.get(selectedCustomer).getActive() == 0) {
			customer = (Customer) allCustomers.get(selectedCustomer);
			return customer;
		}else {
			System.out.println("Please enter a valid customer");
			customer = selectApprovalNeededCustomer(input);
		}
		return customer;
	}
	
}
