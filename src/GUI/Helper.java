package GUI;

import Java.I_User;
import java.util.ArrayList;
import Java.UserState;

import java.sql.SQLException;

import Database.DatabaseAccess;

public class Helper {
	private static DatabaseAccess dba = DatabaseAccess.getInstance();
	private static Helper help = new Helper();
	private I_User user;
	
	private Helper(){
		
	}
	
	public static Helper getInstance(){
		return help;
	}
	
	public boolean canUserLogin(String user, String password){
		return dba.canUserLogin(user, password);
	}
	
	public void getUserDetails(String username){
		user = dba.getUserDetails(username);
	}
	
	public I_User getUser(){
		return user;
	}
	
	public void logoutUser(){
		user = null;
	}
	
	public ArrayList<String> getItems(){
		return dba.getItems();
	}
	
	public int getLastID(){
		return dba.getLastID();
	}
	
	public void registerUser(int id, String userName, int accesslvl, String pass, String email, String address){
		dba.registerUser(id, userName, accesslvl, pass, email, address);
	}
	
	public Object[] getOrders(){
		return dba.getOrders();
	}
}