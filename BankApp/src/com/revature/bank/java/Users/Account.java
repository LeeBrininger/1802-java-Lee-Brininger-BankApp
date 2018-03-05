package com.revature.bank.java.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface Account extends Serializable{
	

	String username = new String();
	String FirstName = new String();
	String LastName = new String();
	int password = 0;
	String email = new String();
	Integer accessLevel = 0;
	List<Integer> walletsOwned = new ArrayList<Integer>();
	
	@Override
	public String toString();

	public String getUsername();
	
	public String getFirstName();
	
	public String getLastName();
	
	public int getPassword();
	
	public String getEmail();
	
	public int getAccessLevel();

}
