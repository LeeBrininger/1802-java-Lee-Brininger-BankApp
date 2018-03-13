package com.revature.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.bank.pojo.Account;
import com.revature.bank.pojo.Admin;
import com.revature.bank.pojo.Customer;
import com.revature.bank.pojo.Employee;
import com.revature.bank.pojo.Wallet;
import com.revature.bank.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class AccountDaoImpl implements AccountDao{

	
	public Boolean createAccount(Account account) {
			
			Connection conn = ConnectionFactory.getInstance().getConnection();
			
			try {
				Statement statement = conn.createStatement();
				
				String sql = "INSERT INTO ACCOUNT VALUES('" +account.getUsername()+"', '"+account.getFirstName()+"', '" + account.getLastName() + "', " +account.getSSN()+", "+account.getPassword()+", '" + account.getEmail()+ "', "+account.getAccessLevel()+", " + 0 + ")";
				statement.executeUpdate(sql);
				conn.commit();
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	}
	
	public Account retrieveAccountByUsername(String name) {
		
		try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM ACCOUNT WHERE USERNAME LIKE '" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            rs.next();
            Account nextAccount = null;
            if(rs.getString(7).equals("3")) {
            	nextAccount = new Admin(rs);
            }
            if(rs.getString(7).equals("2")) {
            	nextAccount = new Employee(rs);
            }
            else {
            	nextAccount = new Customer(rs);
            }
            conn.commit();
            stmt.close();
			return nextAccount;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
		return null;
	}

	public HashMap<String, Account> retrieveAllAccounts() {
		HashMap<String, Account> Accounts = new HashMap<String, Account>();
		
		try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM ACCOUNT";
            Statement stmt = conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            Account nextAccount = null;
            while(rs.next()) {
            	if(rs.getInt(7) == 3) {
                	nextAccount = new Admin(rs);
                }
            	else if(rs.getInt(7) == 2) {
                	nextAccount = new Employee(rs);
                }
                else {
                	nextAccount = new Customer(rs);
                }
                Accounts.put(nextAccount.getUsername(), nextAccount); 
            }
            stmt.close();
            return Accounts;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
		return null;
	}

	
	public List<String> getWalletsOwned(Account account){
		CallableStatement callableStatement = null;
		List<String> walletsOwned = new ArrayList<String>();
		ResultSet rs = null;
		try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            //String sql = "SELECT W1.WALLETNAME FROM WALLET W1 JOIN ACCOUNT_WALLET AW1"
            //		+" ON W1.WALLETNAME LIKE AW1.WALLETNAME JOIN ACCOUNT A1 ON A1.USERNAME LIKE" 
            //		+" AW1.USERNAME WHERE A1.USERNAME LIKE '" + account.getUsername() + "'";
            //ResultSet rs= stmt.executeQuery(sql);
            

            String sql2 = "{CALL GET_ACCOUNTS_WALLETS(?,?)}";
            
            callableStatement = conn.prepareCall(sql2);
            callableStatement.setString(1, account.getUsername());
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
            callableStatement.executeUpdate();
            rs = (ResultSet) callableStatement.getObject(2);
            while(rs.next()) {
            	walletsOwned.add(rs.getString(1));
            	 System.out.println(rs.getString(1));
            }
            rs.close();
            return walletsOwned;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
		return null;
	}
	
	public void addWalletToOwned(Account account, Wallet wallet) {

		try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO ACCOUNT_WALLET VALUES('" + account.getUsername() + "', '" + wallet.getName() + "')";
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            stmt.close();
            conn.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

	}

	public Boolean deleteAccount(Account account) {
		
		try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "DELETE FROM ACCOUNT WHERE USERNAME LIKE '" + account.getUsername() + "'";
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            stmt.close();
            conn.commit();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public Boolean swapToActiveAccount(Account account) {
		
		try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "UPDATE ACCOUNT SET ACTIVEKEY = 1 WHERE USERNAME LIKE '" + account.getUsername() + "'";
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            stmt.close();
            conn.commit();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
		return false;
	}


}
