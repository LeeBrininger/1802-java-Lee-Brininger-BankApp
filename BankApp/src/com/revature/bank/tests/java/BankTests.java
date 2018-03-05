package com.revature.bank.tests.java;

import com.revature.bank.java.BankHub;
import com.revature.bank.java.FileManipulator;
import com.revature.bank.java.MemoryHub;
import com.revature.bank.java.Users.Admin;
import com.revature.bank.java.Users.Customer;
import com.revature.bank.java.Users.Employee;
import com.revature.bank.java.Users.Wallet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;


public class BankTests {

	public static final BankHub bankHub = new BankHub(); 
	
	/*
	 * Interface Tests
	 */
	
	/*
	 * Test the storage and inialize base accounts
	 */
	
	@Test
	public void testFileObjectWrite() {
		HashMap<String, Object> test = new HashMap<String, Object>();
		
		Wallet w1 = new Wallet(101.00, "LeeAccount", "Checking");
		Wallet w2 = new Wallet(500.00, "two", "Savings");
		Wallet w3 = new Wallet(10000.00, "SSB", "Savings");
		
		List<String> walletsowned1 = new ArrayList<String>();
		List<String> walletsowned2 = new ArrayList<String>();
		List<String> walletsowned3 = new ArrayList<String>();
		List<String> walletsowned4 = new ArrayList<String>();
		walletsowned1.add("LeeAccount");
		Customer c1 = new Customer("Crawdady", "Lee", "Brin", "password", "richmondbrininger@gmail.com", 888888888, walletsowned1);
		walletsowned2.add("two");
		Customer c2 = new Customer("NK", "Nick", "Nick", "12345", "nick@gmail.com", 999999999, walletsowned2);
		walletsowned3.add("SSB");
		Customer c3 = new Customer("SSB4", "Chris", "Wagner", "password", "youknowitsthebestSSB@gmail.com", 111111111, walletsowned3);
		walletsowned4.add("LeeAccount");
		walletsowned4.add("two");
		Customer c4 = new Customer("Stuff", "AJ", "Williams", "pass", "morestuff@gmail.com", 343443434, walletsowned4);
		Employee e1 = new Employee("Emp1", "John", "Cena", "54321", "dodododo@yahoo.com", 001112345);
		Employee e2 = new Employee("Emp2", "Cowman", "Sad", "lol", "penguinz0@gmail.com", 954674433);
		Admin a1 = new Admin("Admin", "Richmond", "Brininger", "thebest", "youknowitsthebestSSB@gmail.com", 987345765);
		

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

	/*
	 * Tests the reading from file
	 */
	@Test
	public void testFileObjectReadCustomer() {
		HashMap<String, Object> c1 = FileManipulator.ReadIn("BankInfo.ser");
		Customer in1 = (Customer) c1.get("NK");
		assertEquals("Nick", in1.getFirstName());
	}
	
	@Test
	public void testFileObjectReadEmployee() {
		HashMap<String, Object> c1 = FileManipulator.ReadIn("BankInfo.ser");
		Employee in1 = (Employee) c1.get("Emp1");
		System.out.println("=====" + in1.getAccessLevel());
		assertEquals("Emp1", in1.getUsername());
	}
	
	@Test
	public void testFileObjectReadAdmin() {
		HashMap<String, Object> c1 = FileManipulator.ReadIn("BankInfo.ser");
		Admin in1 = (Admin) c1.get("Admin");
		assertEquals("Brininger", in1.getLastName());
	}
	
	@Test
	public void testFileObjectReadWallet() {
		HashMap<String, Object> c1 = FileManipulator.ReadIn("BankInfo.ser");
		Wallet in1 = (Wallet) c1.get("LeeAccount");
		assertEquals("LeeAccount", in1.getName());
	}
	
	/*
	 * Tests account manipulation
	 */
	@Test
	public void testAddingFunds(){
		MemoryHub.readStored("BankInfo.ser");
		Wallet testW = MemoryHub.getWallets().get("SSB");
		double inital = testW.getMoney();
		testW.addFunds(10);
		assertTrue(Math.abs((inital+10) - testW.getMoney()) < 1);
	}
	
	@Test
	public void testSubtractingFunds(){
		MemoryHub.readStored("BankInfo.ser");
		Wallet testW = MemoryHub.getWallets().get("LeeAccount");
		double inital = testW.getMoney();
		testW.subtractFunds(10);
		assertTrue(Math.abs((inital-10) - testW.getMoney()) < 1);
	}
	
	/*
	 * Test account and wallet creation and deletion
	 */
	@Test
	public void testNewWallet(){
		Wallet NoOwner = new Wallet(10000, "NoOwner", "savings");
		MemoryHub.addWallet(NoOwner);
		assertTrue(MemoryHub.getWallets().containsKey("NoOwner"));
	}

	/*
	 * Test account and wallet creation and deletion
	 */
	@Test
	public void testNewAccount(){
		Customer TestCustomer = new Customer("Username", "FirstName", "LastName", "pass" , "Email", 90909099);
		MemoryHub.addAccount(TestCustomer);
		assertTrue(MemoryHub.getAccounts().containsKey("Username"));
	}
}
