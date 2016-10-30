package GUI;

import Java.I_User;

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
	
	public boolean canUserLogin(String user, String password) throws SQLException{
		return dba.canUserLogin(user, password);
	}
	
	public void getUserDetails(String username) throws SQLException{
		user = dba.getUserDetails(username);
	}
	
	public I_User getUser(){
		return user;
	}
	
	public void logoutUser(){
		user = null;
	}
	
}