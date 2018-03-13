package com.revature.bank.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface Account extends Serializable{


	String username = new String();
	String FirstName = new String();
	String LastName = new String();
	int ssn = 0;
	int password = 0;
	String email = new String();
	Integer accessLevel = new Integer(0);
	List<Integer> walletsOwned = new ArrayList<Integer>();
	Boolean active = new Boolean(false);

	@Override
	public String toString();
	
	public int getActive();
	
	public void printInfo();

	public String getUsername();
	
	public String getFirstName();
	
	public String getLastName();
	
	public int getSSN();
	
	public int getPassword();
	
	public String getEmail();
	
	public int getAccessLevel();

}
