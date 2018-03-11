package com.revature.bank.java.Menus;

import java.util.Scanner;

public class MenuInterface {

	static Scanner input = new Scanner(System.in);
	
	
	public static int runOpen() {
		aesthetics();
		return introQuestions();
	}
		

	public static int introQuestions() {
		String response = "";
		System.out.println("Welcome! Please select your option: ");
		System.out.println("1 - Log In | 2 - Create Profile | 3 - Exit");
		response = input.nextLine();
		if(response.equals("1") || response.equals("2") || response.equals("3")) {
			return Integer.parseInt(response);
		}else {
			System.out.println("Invalid Entry, please enter a valid entry" + '\n');
			return introQuestions();
		}
	}
	

	public static void runLogin() {
		aesthetics();
		MenuLogin.loginMenu();
		clearScreen();
	}
	
	
	public static void runCreateNew() {
		aesthetics();
		MenuCreateNewAccount.runCreate(input);
		clearScreen();
	}
	
	public static void aesthetics() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("First Bank of Richmond");
		System.out.println("'Where your money is as safe as multiple interface extention'");
		System.out.println("--------------------------------------------------------------\n");
	}
	
	
	public static void clearScreen() {
		System.out.println("\n\n\n\n");
	}
}
