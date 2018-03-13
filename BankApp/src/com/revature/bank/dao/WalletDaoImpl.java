package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.revature.bank.java.MemoryHub;
import com.revature.bank.pojo.Wallet;
import com.revature.bank.util.ConnectionFactory;

public class WalletDaoImpl implements WalletDao{

	public Boolean createWallet(Wallet wallet) {
		
		Connection conn = ConnectionFactory.getInstance().getConnection();
	
		try {
			Statement statement = conn.createStatement();
			
			String sql = "INSERT INTO WALLET (WALLETNAME, MONEY_CONTAINED, TYPE) VALUES('"+wallet.getName()+"', '"+wallet.getMoney()+"', '" + wallet.getType() + "')";
			MemoryHub.logToDatabase("DataBase Altered");
			statement.executeUpdate(sql);
			conn.commit();
			 MemoryHub.logToDatabase("Wallet " + wallet.getName() + " created");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Wallet retrieveWalletByName(String name) {
		
		try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM WALLET WHERE WALLETNAME LIKE '" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            rs.next();
            Wallet nextWallet = new Wallet(rs);
            stmt.close();
            MemoryHub.logToDatabase("DataBase Altered");
            return nextWallet;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
		return null;
	}

	public HashMap<String, Wallet> retrieveAllWallets() {
		HashMap<String,Wallet> wallets = new HashMap<String, Wallet>();
		
		try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM WALLET";
            Statement stmt = conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            
            while(rs.next()) {
            	Wallet nextWallet = new Wallet(rs);
            	wallets.put(nextWallet.getName(), nextWallet);
            }
            stmt.close();
            return wallets;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
	}

	public void updateWalletMoney(Wallet wallet) {

		try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "UPDATE WALLET SET MONEY_CONTAINED = '" + wallet.getMoney() + "' WHERE WALLETNAME LIKE '" + wallet.getName() + "'";
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            stmt.close();
            conn.commit();
            MemoryHub.logToDatabase(wallet.getName() + "funds set to " + wallet.getMoney());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
	}

	public Boolean deleteWallet(Wallet wallet) {
		
		try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "DELETE FROM WALLET WHERE WALLETNAME = '" + wallet.getName() + "'";
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            stmt.close();
            conn.commit();
            MemoryHub.logToDatabase("Wallet " + wallet.getName() + " deleted");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
		return true;

	}
}
