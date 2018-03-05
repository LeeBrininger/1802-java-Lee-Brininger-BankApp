package com.revature.bank.java.Users;

public class Employee implements Account{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username = new String();
	private String firstName = new String();
	private String lastName = new String();
	private String email = new String();
	int ssn = 0;
	private int accesslevel = 2;
	private int password = 0;
	private Boolean active = true;
	
	public Employee(String username, String firstname, String lastname, int password, String Email, int Ssn) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.firstName = firstname;
		this.lastName = lastname;
		this.password = password;
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
	public void setPassword(int password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAccesslevel(int accesslevel) {
		this.accesslevel = accesslevel;
	}

	@Override
	public int getAccessLevel() {
		return accessLevel;
	}

	@Override
	public Boolean getActive() {
		return active;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getAccesslevel() {
		return accesslevel;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
	
}
