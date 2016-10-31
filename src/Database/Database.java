package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import SQL.*;

import Java.I_Product;
import Java.I_User;
import Java.ConcreteUser;

/*Concrete database class using Microsoft SQL Server for testing and out of the box functionality
 */

public class Database implements I_Database {
	Connection con;	
	
	@Override
	public void getItems() {
		try{
			Statement mystat = con.createStatement();
			ResultSet myRe = mystat.executeQuery("select * from items");
			while (myRe.next())
			{
				System.out.println(myRe.getString(3));
			}
		}
			catch(SQLException e){
				System.out.println("Error retrieving items from database");
			}
		
	}

	@Override
	public ArrayList<I_Product> getItems(String identifier) {
		return null;
	}
	
	@Override
	public boolean canUserLogin(String user, String password){
		try{
			Select s = new Select("*","users","username",user, con);
			ResultSet myRe = s.getResultset();
			if(myRe.next()){
				String dbPass = myRe.getString(4);
				if (dbPass.equals(password)){
					return true;
				} 	
			}
		}
			catch(SQLException e){
				System.out.println("Error logging user in");
			}
		return false;
		}
	
	@Override
    public boolean connect(String host, int port, String user, String password) {
		return true;
    }
	
	@Override
    public boolean connect(String connectionURL) throws ClassNotFoundException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionURL);  
			
			System.out.println("you are Connected");
			return true;
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return false;
		
		}
    }
	
	@Override
	public I_User getUserDetails(String username){
		try{
			Select s = new Select("*","users","username",username, con);
			ResultSet myRe = s.getResultset();
			if(myRe.next()){
				return new ConcreteUser(Integer.parseInt(myRe.getString(1)),myRe.getString(2), Integer.parseInt(myRe.getString(3)), myRe.getString(4), myRe.getString(5), myRe.getString(6));
			}
		}
		catch(SQLException e){
			System.out.println("Error getting user object from database");
		}
			return null;
		}
	
	public boolean registerUser(int id, String userName, int accesslvl, String pass, String email, String address){
		try{
			Statement mystat = con.createStatement();
			String sql = "INSERT into users (idusers ,username,accesslvl ,password,email,address) VALUES('" 
				 + id  + "','" + userName + "','" + accesslvl+ "','" + pass + "','" + email + "','" + address 
					+ "');" ;
			mystat.executeUpdate(sql);
			return true; 
		}
		catch(SQLException e){
			System.out.println("Error registering user");
		}
		return false;
	}
	
	public int getLastID(){
		try{
			Statement mystat = con.createStatement();
			int id = 1;
			//Get ID for Java.user
			ResultSet myRe = mystat.executeQuery("select * from users");
			while (myRe.next()){
				id++;
			}
			return id;
		}
		catch(SQLException e){
			System.out.println("Error retrieving last id from database");
		}
		return -1;
	}
	
	public Object[] getOrders(){
		Object[] listData;
		int i = 0;
		try
		{
    		Statement mystat = con.createStatement();
			ResultSet myRe = mystat.executeQuery("select * from items");
			//get db data
			while (myRe.next()){
				i++;
			}
			
		}
		catch(Exception exc)
		{
			System.out.println("Database error");
		}
		listData = new Object[i];
		
		i = 0;
		try
		{
  		   Statement mystat = con.createStatement();		
			ResultSet myRe = mystat.executeQuery("select * from orderqueue");
			
			String name = "";
			String qty = "";
			String customer = "";
				
			//get db data
			while (myRe.next())
			{							
				name = "Product Name: " + myRe.getString(1) + ", ";
				qty = "Quantity:  " +  myRe.getInt(2) + ", ";
				customer = "Customer:  " +  myRe.getString(3) + ", ";
													
				listData[i] =name + qty + customer;
				
				i++;
			}
		}
		catch(Exception exc)
		{
			System.out.println("Database error");
		}
		return listData;
	}
}