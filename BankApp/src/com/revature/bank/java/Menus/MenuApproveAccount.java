 package com.revature.bank.java.Menus;

import java.util.HashMap;
import java.util.Scanner;

import com.revature.bank.java.MemoryHub;
import com.revature.bank.java.Users.Account;
import com.revature.bank.java.Users.Customer;

public class MenuApproveAccount {
	
	
	public static void approveAccount(Scanner input) {
		Customer customer;
		String selection = "";
		System.out.println("Please select the applied user you want to view:");
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
			customer.setActive();
			System.out.println("Account approved");
		}else if(selection.equals("deny")) {
			MemoryHub.removeAccount(customer);
			System.out.println("Account denied");
		}
		MemoryHub.storeData();
		return;
	}
	
	
	private static Customer selectApprovalNeededCustomer(Scanner input) {
		HashMap<String, Account> allCustomers = MemoryHub.getAccounts();
		String selectedCustomer = "";
		Customer customer;
		
		System.out.println("Customers waiting for approval: (Enter 1 to exit)\n");
		for(HashMap.Entry<String, Account> acc : allCustomers.entrySet()) {
			if(acc.getValue() instanceof Customer && !acc.getValue().getActive()) {
				System.out.println(acc.getKey());
			}
		}
		selectedCustomer = input.nextLine();
		if(selectedCustomer.equals("1")) {
			return null;
		}
		if(allCustomers.containsKey(selectedCustomer) && allCustomers.get(selectedCustomer) instanceof Customer && !allCustomers.get(selectedCustomer).getActive()) {
			customer = (Customer) allCustomers.get(selectedCustomer);
			return customer;
		}else {
			System.out.println("Please enter a valid customer");
			customer = selectApprovalNeededCustomer(input);
		}
		return customer;
	}
	
}