package com.revature.bank.tests.java;

import com.revature.bank.java.BankHub;
import com.revature.bank.java.FileManipulator;
import com.revature.bank.java.Users.Account;
import com.revature.bank.java.Users.Admin;
import com.revature.bank.java.Users.Customer;
import com.revature.bank.java.Users.Employee;
import com.revature.bank.java.Users.Wallet;
import com.revature.bank.util.LoggingUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class BankTests {

	public static final BankHub bankHub = new BankHub(); 
	
	/*
	 * Interface Tests
	 */
	@Test
	public void testFileObjectWrite() {
		HashMap<String, Object> test = new HashMap<String, Object>();
		
		Wallet w1 = new Wallet(101.00, "one");
		Wallet w2 = new Wallet(500.00, "two");
		Wallet w3 = new Wallet(10000.00, "three");
		
		List<String> walletsowned = new ArrayList<String>();
		walletsowned.add("one");
		Customer c1 = new Customer("Crawdady", "Lee", "Brin", ("password" + "lee").hashCode(), "richmondbrininger@gmail.com", walletsowned);
		walletsowned.clear();
		walletsowned.add("two");
		Customer c2 = new Customer("NK", "Nick", "Nick", ("12345" + "lee").hashCode(), "nick@gmail.com", walletsowned);
		walletsowned.clear();
		walletsowned.add("three");
		Customer c3 = new Customer("SSB4", "Chris", "Wagner", ("password" + "lee").hashCode(), "youknowitsthebestSSB@gmail.com", walletsowned);
		walletsowned.clear();
		walletsowned.add("one");
		walletsowned.add("two");
		Customer c4 = new Customer("Stuff", "AJ", "Williams", ("pass" + "lee").hashCode(), "morestuff@gmail.com", walletsowned);
		Employee e1 = new Employee("Emp1", "John", "Cena", ("93o4tgn" + "lee").hashCode(), "dodododo@yahoo.com");
		Employee e2 = new Employee("Emp2", "Cowman", "Sad", ("jklol5" + "lee").hashCode(), "penguinz0@gmail.com");
		Admin a1 = new Admin("Admin", "Richmond", "Brininger", ("thebest" + "lee").hashCode(), "youknowitsthebestSSB@gmail.com");
		
		
		
		test.put(c1.getUsername(), c1);
		test.put(c2.getUsername(), c2);
		test.put(c3.getUsername(), c3);
		test.put(c4.getUsername(), c4);
		test.put(e1.getUsername(), e1);
		test.put(e2.getUsername(), e2);
		test.put(a1.getUsername(), a1);
		test.put(w1.getName(), w1);
		test.put(w2.getName(),w2);
		test.put(w3.getName(),w3);
		FileManipulator.WriteOut(test, "BankInfo.ser");
	}

	@Test
	public void testFileObjectReadCustomer() {
		HashMap<String, Object> c1 = FileManipulator.ReadIn("BankInfo.ser");
		Customer in1 = (Customer) c1.get("NK");
		LoggingUtil.logInfo(in1.getFirstName());
		assertEquals("Nick", in1.getFirstName());
	}
	
	@Test
	public void testFileObjectReadEmployee() {
		HashMap<String, Object> c1 = FileManipulator.ReadIn("BankInfo.ser");
		Employee in1 = (Employee) c1.get("Emp1");
		LoggingUtil.logInfo(in1.getUsername());
		assertEquals("Emp1", in1.getUsername());
	}
	
	@Test
	public void testFileObjectReadAdmin() {
		HashMap<String, Object> c1 = FileManipulator.ReadIn("BankInfo.ser");
		Admin in1 = (Admin) c1.get("Admin");
		LoggingUtil.logInfo("" + in1.getPassword());
		assertEquals("Brininger", in1.getLastName());
	}
	
	@Test
	public void testFileObjectReadWallet() {
		HashMap<String, Object> c1 = FileManipulator.ReadIn("BankInfo.ser");
		Wallet in1 = (Wallet) c1.get("one");
		LoggingUtil.logInfo(in1.getName());
		assertEquals("one", in1.getName());
	}

}
