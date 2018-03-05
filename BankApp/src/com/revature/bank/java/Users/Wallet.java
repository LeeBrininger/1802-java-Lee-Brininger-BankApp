package com.revature.bank.java.Users;

import java.util.Random;
import java.io.Serializable;

public class Wallet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double money;
	private int address;
	private String name;
	

	public Wallet(double d, String Name) {
		this.money = d;
		this.name = Name;
		Random rand = new Random();
		this.address = rand.nextInt();
	}

	public boolean addFunds(double ammount) {
		if(ammount > 0) {
			this.money = this.money+ammount;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean subtractFunds(double ammount) {
		if(this.money-ammount > 0) {
			this.money = this.money-ammount;
			return true;
		}else {
			return false;
		}
	}
	
	public void redoAddress() {
		Random rand = new Random();
		this.address = rand.nextInt();
	}	
	
	public int getAddress() {
		return address;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
