package com.revature.bank.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee implements Account{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username = new String();
	private String firstName = new String();
	private String lastName = new String();
	private String email = new String();
	private int ssn = 0;
	private int accessLevel = 2;
	private int password = 0;
	private int active = 1;
	
	
	public Employee(ResultSet rs) {
		 try {
				this.username = rs.getString(1);
				this.firstName = rs.getString(2);
				this.lastName = rs.getString(3);
				this.ssn = rs.getInt(4);
				this.password = rs.getInt(5);
				this.email = rs.getString(6);
				this.accessLevel = rs.getInt(7);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	public Employee(String username, String firstname, String lastname, String password, String Email, int Ssn) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.firstName = firstname;
		this.lastName = lastname;
		this.password = (password + "lee").hashCode();
		this.email = Email;
		this.ssn = Ssn;
	}
	
	@Override
	public void printInfo() {
		System.out.println("Username: " + username);
		System.out.println("FirstName: " + firstName);
		System.out.println("LastName: " + lastName);
		System.out.println("Email: " + email);
		System.out.println("SSN: " + ssn);
		System.out.println("Password is not saved, the hash is: "+ password);
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
	public void setPassword(String password) {
		this.password = (password + "lee").hashCode();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int getActive() {
		return active;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	@Override
	public int getAccessLevel() {
		return accessLevel;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public int getSSN() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
