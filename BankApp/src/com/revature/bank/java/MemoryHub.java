package com.revature.bank.java;

import java.util.HashMap;
import java.util.List;
import com.revature.bank.dao.AccountDao;
import com.revature.bank.dao.AccountDaoImpl;
import com.revature.bank.dao.LogDao;
import com.revature.bank.dao.LogDaoImpl;
import com.revature.bank.dao.WalletDao;
import com.revature.bank.dao.WalletDaoImpl;
import com.revature.bank.pojo.Account;
import com.revature.bank.pojo.Wallet;
import com.revature.bank.util.LoggingUtil;

public class MemoryHub {

	
	static AccountDao ad = new AccountDaoImpl();
	static WalletDao wd = new WalletDaoImpl();
	static LogDao ld = new LogDaoImpl();
	
	
	
	public static void storeFundsChange(Wallet wallet) {
		wd.updateWalletMoney(wallet);
	}
	
	
	public static void addAccount(Account account) {
		ad.createAccount(account);
		LoggingUtil.logInfo("Account " + account.getUsername() + " added");
	}
	
	public static void removeAccount(Account account) {
		ad.deleteAccount(account);
		LoggingUtil.logInfo("Account " + account.getUsername() + " removed");
	}

	public static void addWallet(Wallet wallet) {
		wd.createWallet(wallet);
		LoggingUtil.logInfo("Wallet " + wallet.getName() + " added");
	}
	
	public static void removeWallet(Wallet wallet) {
		wd.deleteWallet(wallet);
		LoggingUtil.logInfo("Wallet " + wallet.getName() + " removed");
	}
	
	public static HashMap<String, Account> getAccounts() {
		return ad.retrieveAllAccounts();
	}

	public static HashMap<String, Wallet> getWallets() {
		return wd.retrieveAllWallets();
	}

	public static List<String> getCustomerWallets(Account account){
		return ad.getWalletsOwned(account); 
	}

	public static void addWalletOwned(Account account, Wallet wallet) {
		ad.addWalletToOwned(account, wallet);
	}
	
	public static void swapToActiveAccount(Account account) {
		ad.swapToActiveAccount(account);
	}

	public static void logToDatabase(String info) {
		ld.storeLog(info);
	}
	
}
