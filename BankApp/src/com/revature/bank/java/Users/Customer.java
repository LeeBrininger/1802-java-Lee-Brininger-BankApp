package com.revature.bank.java.Users;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Account{
	private String username = new String();
	private String firstName = new String();
	private String lastName = new String();
	private int password = 0;
	int ssn = 0;
	private String email = new String();
	private int accessLevel = 1;
	private List<String> walletsOwned = new ArrayList<String>();
	private Boolean active = true;


	private static final long serialVersionUID = 1L;
	
	public Customer(){};
	
	public Customer(String Username, String FirstName, String LastName, int Password, String Email, int Ssn, List<String> walletsowned) {
		this.username = Username;
		this.firstName = FirstName;
		this.lastName = LastName;
		this.password = Password;
		this.email = Email;
		this.ssn = Ssn;
		this.walletsOwned = walletsowned;
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
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive() {
		this.active = true;
	}
	
	public void setUnActive() {
		this.active = false;
	}

	public int getSSN() {
		return ssn;
	}

	public void setSSN(int sSN) {
		ssn = sSN;
	}

	

}
