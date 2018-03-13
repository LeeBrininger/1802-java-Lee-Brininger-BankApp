package com.revature.bank.tests.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bank.dao.AccountDao;
import com.revature.bank.dao.AccountDaoImpl;
import com.revature.bank.dao.WalletDao;
import com.revature.bank.dao.WalletDaoImpl;
import com.revature.bank.java.BankHub;
import com.revature.bank.java.MemoryHub;
import com.revature.bank.pojo.Account;
import com.revature.bank.pojo.Admin;
import com.revature.bank.pojo.Customer;
import com.revature.bank.pojo.Employee;
import com.revature.bank.pojo.Wallet;


public class BankTests {

	public static final BankHub bankHub = new BankHub(); 
	static String defaultFile = "BankInfo.txt";
	static AccountDao ad = new AccountDaoImpl();
	static WalletDao wd = new WalletDaoImpl();
	/*
	 * Interface Tests
	 */

	/*
	 * Test the storage and inialize base accounts
	 */
	
	@BeforeClass
	public static void createAccount() {
		Wallet w1 = new Wallet("LeeAccount", 101.00,  "Checking");
		Wallet w2 = new Wallet("two", 500.00,  "Savings");
		Wallet w3 = new Wallet("SSB", 10000.00, "Savings");
		
		List<String> walletsowned1 = new ArrayList<String>();
		List<String> walletsowned2 = new ArrayList<String>();
		List<String> walletsowned3 = new ArrayList<String>();
		List<String> walletsowned4 = new ArrayList<String>();
		walletsowned1.add("LeeAccount");
		Customer c1 = new Customer("Crawdady", "Lee", "B", "password", "richmondbrininger@gmail.com", 888888888, 1);
		walletsowned2.add("two");
		Customer c2 = new Customer("NK", "Nick", "Nick", "12345", "nick@gmail.com", 999999999, 1);
		walletsowned3.add("SSB");
		Customer c3 = new Customer("SSB4", "Chris", "Wagner", "password", "youknowitsthebestSSB@gmail.com", 111111111, 1);
		walletsowned4.add("LeeAccount");
		walletsowned4.add("two");
		Customer c4 = new Customer("Stuff", "AJ", "Williams", "pass", "morestuff@gmail.com", 343443434, 1);
		Employee e1 = new Employee("Emp1", "John", "Cena", "54321", "dodododo@yahoo.com", 001112345);
		Employee e2 = new Employee("Emp2", "Cowman", "Sad", "lol", "penguinz0@gmail.com", 954674433);
		Admin a1 = new Admin("Admin", "Richmond", "Brininger", "thebest", "importantstuff@gmail.com", 987345765);
		
		//ad.createAccount(c1);
		//ad.createAccount(c2);
		//ad.createAccount(c3);
		//ad.createAccount(c4);
		//ad.createAccount(e1);
		//ad.createAccount(e2);
		//ad.createAccount(a1);
		//wd.createWallet(w1);
		//wd.createWallet(w2);
		//wd.createWallet(w3);
	}

	/*
	 * Tests the reading from file (LEGACY TESTS)
	 */
	/*
	@Test
	public void testFileObjectReadCustomer() {
		HashMap<String, Object> c1 = FileManipulator.ReadIn(defaultFile);
		Customer in1 = (Customer) c1.get("NK");
		assertEquals("Nick", in1.getFirstName());
	}
	
	@Test
	public void testFileObjectReadEmployee() {
		HashMap<String, Object> c1 = FileManipulator.ReadIn(defaultFile);
		Employee in1 = (Employee) c1.get("Emp1");
		assertEquals("Emp1", in1.getUsername());
	}
	
	@Test
	public void testFileObjectReadAdmin() {
		HashMap<String, Object> c1 = FileManipulator.ReadIn(defaultFile);
		Admin in1 = (Admin) c1.get("Admin");
		assertEquals("Brininger", in1.getLastName());
	}
	
	@Test
	public void testFileObjectReadWallet() {
		HashMap<String, Object> c1 = FileManipulator.ReadIn(defaultFile);
		Wallet in1 = (Wallet) c1.get("LeeAccount");
		assertEquals("LeeAccount", in1.getName());
	}
	
	
	
	 //Tests account manipulation
	 
	@Test
	public void testAddingFunds(){
		MemoryHub.readStored(defaultFile);
		Wallet testW = MemoryHub.getWallets().get("SSB");
		double inital = testW.getMoney();
		testW.addFunds(10);
		assertTrue(Math.abs((inital+10) - testW.getMoney()) < 1);
	}
	
	@Test
	public void testSubtractingFunds(){
		MemoryHub.readStored(defaultFile);
		Wallet testW = MemoryHub.getWallets().get("LeeAccount");
		double inital = testW.getMoney();
		testW.subtractFunds(10);
		assertTrue(Math.abs((inital-10) - testW.getMoney()) < 1);
	}
	*/

	
	@Test
	public void testWalletCreation() {
		//Wallet test = new Wallet("test", 1000, "Checking");
		//WalletDao.createWallet(test);
	}
	
	@Test
	public void testGetWalletByName() {
		Wallet test = wd.retrieveWalletByName("LeeAccount");
		assertEquals(test.getName(), "LeeAccount");
	}
	
	@Test
	public void testGetAllWallets() {
		Map<String, Wallet> testList = wd.retrieveAllWallets();
		assertEquals(testList.get("LeeAccount").getType(), "Checking");
	}
	
	@Test
	public void testUpdateMoney() {
		Wallet test = wd.retrieveWalletByName("LeeAccount");
		double inital = test.getMoney();
		test.addFunds(234);
		wd.updateWalletMoney(test);
		test = wd.retrieveWalletByName("LeeAccount");
		assertEquals(test.getMoney(), inital+234, 0.1);
	}
	
	
	@Test
	public void testDeleteWallet(){
		Wallet test = new Wallet("test", 1000, "Checking");
		//wd.createWallet(test);
		//assertTrue(wd.deleteWallet(test));
	}
	

	@Test
	public void testAccountCreation() {
		Customer customer = new Customer("TestDude", "Lea", "Kree", "password", "brininger@gmail.com", 888888887, 1);
		//assertTrue(ad.createAccount(customer));
	}
	
	
	@Test
	public void testGetAccountByUsername() {
		Account test = ad.retrieveAccountByUsername("Stuff");
		assertEquals(test.getFirstName(), "AJ");
	}
	
	@Test
	public void testGetAllAccounts() {
		Map<String, Account> testList = ad.retrieveAllAccounts();
		assertEquals(testList.get("Crawdady").getLastName(), "B");
	}

	@Test
	public void testDeleteAccount() {
		//Account test = ad.retrieveAccountByUsername("TestDude");
		//assertTrue(ad.deleteAccount(test));
	}
	
	
	@Test
	public void getWalletsOwned() {
		Account customer = ad.retrieveAccountByUsername("Stuff");
		List<String> walletList = ad.getWalletsOwned(customer);
		assertEquals(walletList.get(0), "LeeAccount");
	}
	
	@Test
	public void addWalletToAccount() {
		Account customer = ad.retrieveAccountByUsername("NK");
		Wallet test = wd.retrieveWalletByName("LeeAccount");
		//ad.addWalletToOwned(customer, test);
	}
	
	@Test
	public void addLog() {
		MemoryHub.logToDatabase("Test Log");
	}

}
