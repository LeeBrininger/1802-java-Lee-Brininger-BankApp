package com.revature.bank.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.bank.java.Menus.MenuInterface;
import com.revature.bank.util.ConnectionFactory;
import com.revature.bank.util.LoggingUtil;

public class BankHub {
	static Scanner input = new Scanner(System.in);
	static MenuInterface menus = new MenuInterface();
	
	private static String defaultDataFile = "BankInfo.txt";
	
	public static String getFile() {
		return defaultDataFile;
	}

	public static void main(String[] args) {
		LoggingUtil.logInfo("System opened");
		MemoryHub.logToDatabase("System opened");
		commandTree();
	}

	
	public static void commandTree() {
		double option = MenuInterface.runOpen();
		
		switch((int)option) {
		case 1:
			MenuInterface.runLogin();
			break;
		case 2:
			MenuInterface.runCreateNew();
			break;
		case 3:
			LoggingUtil.logInfo("System closed");
			MemoryHub.logToDatabase("System closed");
			System.exit(0);
		default:
			System.out.println("Please enter one of the options");
			commandTree();
		}	
	}
}
