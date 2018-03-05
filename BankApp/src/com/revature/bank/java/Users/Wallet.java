package com.revature.bank.java.Users;

import java.io.Serializable;

import com.revature.bank.util.LoggingUtil;

public class Wallet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double money = 0;
	private String name;
	private String type;
	
	public Wallet() {}
	
	public Wallet(double d, String Name, String Type) {
		this.money = d;
		this.name = Name;
		this.type = Type;
		LoggingUtil.logInfo("Wallet" + name + " created with $" + money + " of type " + type);
	}
	
	public void printInfo() {
		System.out.println("Account name: " + name);
		System.out.println("Account money: " + money);
		System.out.println("Account type: " + type);
	}

	public boolean addFunds(double ammount) {
		if(ammount > 0) {
			
			this.money = this.money+ammount;
			LoggingUtil.logInfo("$" + ammount + " added to wallet " + name + ", new balance is " + money);
			return true;
		}else {
			LoggingUtil.logInfo("Negative money request from wallet " + name);
			return false;
		}
	}
	
	public boolean subtractFunds(double ammount) {
		if(this.money-ammount > 0) {
			this.money = this.money-ammount;
			LoggingUtil.logInfo("$" + ammount + " withdrawn from wallet " + name + ", new balance is " + money);
			return true;
		}else {
			LoggingUtil.logInfo("Overdraw request from wallet " + name);
			return false;
		}
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
		LoggingUtil.logInfo("Wallet " + name + " set with funding " + money);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
