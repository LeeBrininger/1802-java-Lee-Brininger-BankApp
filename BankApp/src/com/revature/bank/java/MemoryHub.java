package com.revature.bank.java;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import com.revature.bank.java.Users.Account;
import com.revature.bank.java.Users.Customer;
import com.revature.bank.java.Users.Wallet;
import com.revature.bank.util.LoggingUtil;

public class MemoryHub {
	
	private static HashMap<String, Account> accounts = new HashMap<String, Account>();
	private static HashMap<String, Wallet> wallets = new HashMap<String, Wallet>();


	public static void readStored(String file) {
		
		HashMap<String, Object> storedData = FileManipulator.ReadIn(file);
		for(HashMap.Entry<String, Object> me : storedData.entrySet()) {
			
			if(me.getValue() instanceof Account) {
				accounts.put(me.getKey(), (Account) me.getValue());
			}
			else if(me.getValue() instanceof Wallet) {
				wallets.put(me.getKey(), (Wallet) me.getValue());
			}
		}
		//LoggingUtil.logInfo(accounts.get("Crawdady").getFirstName());
	}
	
	public static void storeData() {
		HashMap<String, Object> allData = new HashMap<String, Object>();
		
		for(HashMap.Entry<String, Account> acc : accounts.entrySet()) {
			allData.put(acc.getKey(), acc.getValue());
		}
		for(HashMap.Entry<String, Wallet> wal : wallets.entrySet()) {
			allData.put(wal.getKey(), wal.getValue());
		}
		
		FileManipulator.WriteOut(allData, BankHub.getFile());
	}

	public static HashMap<String, Account> getAccounts() {
		return accounts;
	}


	public static void setAccounts(HashMap<String, Account> accounts) {
		MemoryHub.accounts = accounts;
	}


	public static HashMap<String, Wallet> getWallets() {
		return wallets;
	}


	public static void setWallets(HashMap<String, Wallet> wallets) {
		MemoryHub.wallets = wallets;
	}
	
}
