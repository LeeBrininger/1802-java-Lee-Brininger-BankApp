package com.revature.bank.java.Users;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Account{
	private String username = new String();
	private String firstName = new String();
	private String lastName = new String();
	private int password = 0;
	private String email = new String();
	private Integer accessLevel = 1;
	private List<String> walletsOwned = new ArrayList<String>();
	

	private static final long serialVersionUID = 1L;
	
	public Customer(){};
	
	public Customer(String Username, String FirstName, String LastName, int Password, String Email, List<String> walletsowned) {
		this.username = Username;
		this.firstName = FirstName;
		this.lastName = LastName;
		this.password = Password;
		this.email = Email;
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

	@Override
	public String toString() {
		return new StringBuffer(" Username: ").append(this.username)
				.append( "firstName : ").append(this.firstName)
				.append( "lastName : ").append(this.lastName)
				.append( "password : ").append(this.password)
				.append( "email : ").append(this.email)
				.append( " accessLevel : ").append(this.accessLevel)
				.append('\n').toString();
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

	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}
	
}
