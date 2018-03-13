package com.revature.bank.dao;

import java.util.HashMap;
import java.util.List;

import com.revature.bank.pojo.Account;
import com.revature.bank.pojo.Wallet;

public interface AccountDao {

	public Boolean createAccount(Account account);

	public Account retrieveAccountByUsername(String name);

	public HashMap<String, Account> retrieveAllAccounts();
	
	public List<String> getWalletsOwned(Account account);
	
	public void addWalletToOwned(Account account, Wallet wallet);

	public Boolean deleteAccount(Account account);

	public Boolean swapToActiveAccount(Account account);
}
