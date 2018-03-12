package com.revature.bank.dao;

import java.util.HashMap;

import com.revature.bank.pojo.Wallet;

public interface WalletDao {
	
	public Boolean createWallet(Wallet wallet);

	public Wallet retrieveWalletByName(String name);

	public HashMap<String, Wallet> retrieveAllWallets();

	public void updateWalletMoney(Wallet wallet);
	
	public  Boolean deleteWallet(Wallet wallet);
}
