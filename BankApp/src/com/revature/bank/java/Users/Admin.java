package com.revature.bank.java.Users;

public class Admin implements Account{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String username = new String();
	String firstName = new String();
	String lastName = new String();
	int password = 0;
	Integer accessLevel = 3;

	public Admin(String username, String firstname, String lastname, int password, String accesslevel) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.firstName = firstname;
		this.lastName = lastname;
		this.password = password;
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

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

}
