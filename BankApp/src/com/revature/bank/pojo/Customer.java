package com.revature.bank.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.java.MemoryHub;
import com.revature.bank.util.LoggingUtil;

public class Customer implements Account{
	private String username = new String();
	private String firstName = new String();
	private String lastName = new String();
	private int password = 0;
	private int ssn = 0;
	private String email = new String();
	private int accessLevel = 1;
	private List<String> walletsOwned = new ArrayList<String>();
	private int active = 0;


	private static final long serialVersionUID = 1L;
	
	public Customer(){
		LoggingUtil.logInfo("Created new blank customer");
	};
	
	
	public Customer(ResultSet rs) {
		 try {
				this.username = rs.getString(1);
				this.firstName = rs.getString(2);
				this.lastName = rs.getString(3);
				this.ssn = rs.getInt(4);
				this.password = rs.getInt(5);
				this.email = rs.getString(6);
				this.accessLevel = rs.getInt(7);
				this.active = rs.getInt(8);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public Customer(String Username, String FirstName, String LastName, String Password, String Email, int Ssn, int Active) {
		this.username = Username;
		this.firstName = FirstName;
		this.lastName = LastName;
		this.password = (Password + "lee").hashCode();
		this.email = Email;
		this.ssn = Ssn;
		this.active = Active;
		LoggingUtil.logInfo("Created new Customer with:\nusername: " + username + "\nfirst name: " + firstName + 
				"\nlast name: " + lastName + "\npassword: " + password + "\nemail: " + email + "\nSSN: " + ssn);
	}
	
	
	public Boolean addWallet(String walletName) {
		if(walletsOwned.contains(walletName)) {
			return false;
		}else {
			walletsOwned.add(walletName);
			return true;
		}
	}
	
	public Boolean removeWallet(String walletName) {
		if(walletsOwned.contains(walletName)) {
			walletsOwned.remove(walletName);
			return true;
		}else {
			return false;
		}
	}
	
	public List<String> getWalletsOwned() {
		return walletsOwned;
	}
	
	public void printInfo() {
		System.out.println("Username: " + username);
		System.out.println("FirstName: " + firstName);
		System.out.println("LastName: " + lastName);
		System.out.println("Email: " + email);
		System.out.println("SSN: " + ssn);
		System.out.println("Accounts owned:");
		for(int i = 0; i < walletsOwned.size(); i++) {
			System.out.println("-" + walletsOwned.get(i));
		}
		System.out.println("Password is not saved, the hash is: "+ password);
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		LoggingUtil.logInfo("For Account:" + username + " " + "Email set as " + email);
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		LoggingUtil.logInfo("For Account:" + username + " " + "Username set as " + username);
		this.username = username; 
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		LoggingUtil.logInfo("For Account:" + username + " " + "firstName set as " + firstName);
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		LoggingUtil.logInfo("For Account:" + username + " " + "lastName set as " + lastName);
		this.lastName = lastName;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(String Password) {
		this.password = (Password + "lee").hashCode();
		LoggingUtil.logInfo("For Account:" + username + " " + "password set as hash" + password);
	}

	@Override
	public int getAccessLevel() {
		return accessLevel;
	}

	public int getActive() {
		return active;
	}

	//public void setActive() {
	//	LoggingUtil.logInfo("For Account:" + username + " activated");
	//	this.active = 1;
	//}
	
	public void setUnActive() {
		LoggingUtil.logInfo("For Account:" + username + " not activated");
		this.active = 0;
	}

	public int getSSN() {
		return ssn;
	}

	public void setSSN(int sSN) {
		LoggingUtil.logInfo("For Account:" + username + " " + "SSN set as " + firstName);
		ssn = sSN;
	}

	

}
