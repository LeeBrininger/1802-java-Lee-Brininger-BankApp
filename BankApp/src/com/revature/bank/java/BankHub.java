package com.revature.bank.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.bank.java.Menus.MenuInterface;
import com.revature.bank.util.ConnectionFactory;
import com.revature.bank.util.LoggingUtil;

public class BankHub {
	static Scanner input = new Scanner(System.in);
	static MenuInterface menus = new MenuInterface();
	
	private static String defaultDataFile = "BankInfo.txt";
	
	public static String getFile() {
		return defaultDataFile;
	}
	
	public static void main(String[] args) {
		
		
		//displaySql();
		
		
		LoggingUtil.logInfo("System opened");
		MemoryHub.readStored(defaultDataFile);
		commandTree();
	}
	
	
	public static void commandTree() {
		double option = MenuInterface.runOpen();
		
		switch((int)option) {
		case 1:
			MenuInterface.runLogin();
			break;
		case 2:
			MenuInterface.runCreateNew();
			break;
		case 3:
			MemoryHub.storeData();
			LoggingUtil.logInfo("System closed");
			System.exit(0);
		default:
			System.out.println("Please enter one of the options");
			commandTree();
		}	
	}
	
	
	
public static void displaySql(){
        
        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            System.out.println("Connected");
            String sql = "SELECT * FROM EMPLOYEE";
            Statement stmt = conn.createStatement();
            
            ResultSet rs= stmt.executeQuery(sql);
            
            while(rs.next()) {
                System.out.println(rs.getRow());
                System.out.println(rs.getString(3));

                
            }
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        
    }
}
