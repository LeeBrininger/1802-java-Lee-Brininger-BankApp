package com.revature.bank.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.revature.bank.dao.AccountDao;
import com.revature.bank.dao.AccountDaoImpl;
import com.revature.bank.dao.WalletDao;
import com.revature.bank.dao.WalletDaoImpl;
import com.revature.bank.pojo.Account;
import com.revature.bank.pojo.Wallet;
import com.revature.bank.util.ConnectionFactory;
import com.revature.bank.util.LoggingUtil;

public class MemoryHub {
	
	//private static HashMap<String, Account> accounts = new HashMap<String, Account>();
	//private static HashMap<String, Wallet> wallets = new HashMap<String, Wallet>();

	static AccountDao ad = new AccountDaoImpl();
	static WalletDao wd = new WalletDaoImpl();
	
	
	
	public static void storeFundsChange(Wallet wallet) {
		wd.updateWalletMoney(wallet);
	}
	
	
	public static void addAccount(Account account) {
		//accounts.put(account.getUsername(), account);
		ad.createAccount(account);
		LoggingUtil.logInfo("Account " + account.getUsername() + " added");
	}
	
	public static void removeAccount(Account account) {
		//accounts.remove(account.getUsername());
		ad.deleteAccount(account);
		LoggingUtil.logInfo("Account " + account.getUsername() + " removed");
	}

	public static void addWallet(Wallet wallet) {
		//wallets.put(wallet.getName(), wallet);
		wd.createWallet(wallet);
		LoggingUtil.logInfo("Wallet " + wallet.getName() + " added");
	}
	
	public static void removeWallet(Wallet wallet) {
		//wallets.remove(wallet.getName());
		wd.deleteWallet(wallet);
		LoggingUtil.logInfo("Wallet " + wallet.getName() + " removed");
	}
	
	public static HashMap<String, Account> getAccounts() {
		return ad.retrieveAllAccounts();
	}

	public static HashMap<String, Wallet> getWallets() {
		return wd.retrieveAllWallets();
	}


	//public static void setWallets(HashMap<String, Wallet> wallets) {
	//	MemoryHub.wallets = wallets;
	//}
	
}
