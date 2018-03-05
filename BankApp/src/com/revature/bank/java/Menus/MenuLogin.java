package com.revature.bank.java.Menus;

import java.util.HashMap;
import java.util.Scanner;

import com.revature.bank.java.BankHub;
import com.revature.bank.java.MemoryHub;
import com.revature.bank.java.Users.Account;

public class MenuLogin {
	
	static Scanner input = new Scanner(System.in);
	
	public static void loginMenu() {
		
		HashMap<String, Account> users = MemoryHub.getAccounts();
		
		System.out.println("Please enter Username: ");
		String username = input.nextLine();
		String password = "";
		int hash = 0;

		
		if(users.containsKey(username)) {
			Account user = users.get(username);
			System.out.println("Welcome back " + username);
			System.out.println("Please enter your password: ");
			password = input.nextLine();
			password = password + "lee"; //salts the password hash
			hash = password.hashCode();
			if(user.getPassword() == hash){ //compares the hashes
				MenuInterface.clearScreen();
				switch(user.getAccessLevel()) {
				case 1:
					MenuLoggedInInterface.preformCustomer(user, null, input);
					break;
				case 2:
					MenuLoggedInInterface.preformEmployee(user, input);
					break;
				case 3:
					MenuLoggedInInterface.preformAdmin(user, input);
					break;
				}
			}else {
				System.out.println("Password does not match");
				BankHub.commandTree();
			}
		}else {
			System.out.println("Username not Found");
			BankHub.commandTree();
		}
		
	}
}
