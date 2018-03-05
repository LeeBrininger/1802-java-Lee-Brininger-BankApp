package com.revature.bank.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class FileManipulator {
		
	
	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> ReadIn(String databank) {
		HashMap<String, Object> des = new HashMap<String, Object>();

		try {
			FileInputStream fi = new FileInputStream(new File(databank));
			ObjectInputStream in = new ObjectInputStream(fi);
			des = (HashMap<String, Object>) in.readObject();
			in.close();
			fi.close();	
			return des;	 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void WriteOut(HashMap<String, Object> account, String dataBank) {
		
		try {
			FileOutputStream fo = new FileOutputStream(dataBank);
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(account);
			out.close();
			fo.close(); 
		}catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
