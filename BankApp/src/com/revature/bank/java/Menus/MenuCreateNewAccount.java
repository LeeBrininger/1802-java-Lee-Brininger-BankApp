package com.revature.bank.java.Menus;

import java.util.Scanner;

import com.revature.bank.java.Users.Customer;

public class MenuCreateNewAccount {
	
	static Scanner input = new Scanner(System.in);   
	
	public static Customer runCreate(Scanner input) {
		Customer newCust = new Customer();
		System.out.println("Thank You for Choosing the First Bank of Richmond");
		System.out.println("Please follow the prompts below to set up your account.\n");
		System.out.println("Please Enter your firstname: ");
		newCust.setFirstName(input.nextLine());
		System.out.println("Please Enter your last name: ");
		newCust.setLastName(input.nextLine());
		System.out.println("Please Set your Username: ");
		newCust.setUsername(input.nextLine());
		System.out.println("Please Set your Password: ");
		newCust.setPassword((input.nextLine() + "Lee").hashCode());
		System.out.println("Please Enter your e-mail: ");
		newCust.setEmail(input.nextLine());
		return newCust;
	}
}
