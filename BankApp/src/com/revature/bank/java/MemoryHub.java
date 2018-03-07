package com.revature.bank.java;

import java.util.HashMap;
import com.revature.bank.java.Users.Account;
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
		LoggingUtil.logInfo("Data Read in from file");
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
		LoggingUtil.logInfo("Data Written to file");
	}
	
	
	public static void addAccount(Account account) {
		accounts.put(account.getUsername(), account);
		LoggingUtil.logInfo("Account " + account.getUsername() + " added");
	}
	
	public static void removeAccount(Account account) {
		accounts.remove(account.getUsername());
		LoggingUtil.logInfo("Account " + account.getUsername() + " removed");
	}

	public static void addWallet(Wallet wallet) {
		wallets.put(wallet.getName(), wallet);
		LoggingUtil.logInfo("Wallet " + wallet.getName() + " added");
	}
	
	public static void removeWallet(Wallet wallet) {
		wallets.remove(wallet.getName());
		LoggingUtil.logInfo("Wallet " + wallet.getName() + " removed");
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
