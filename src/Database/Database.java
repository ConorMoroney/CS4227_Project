package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
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
	public ArrayList<I_Product> getItems() {
		return null;
	}

	@Override
	public ArrayList<I_Product> getItems(String identifier) {
		return null;
	}
	
	@Override
	public boolean canUserLogin(String user, String password) throws SQLException{
		Select s = new Select("*","users","username",user, con);
        ResultSet myRe = s.getResultset();
        if(myRe.next()){
    		String dbPass = myRe.getString(4);
    		if (dbPass.equals(password)){
    			return true;
    		} 	
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
	public I_User getUserDetails(String username) throws SQLException{
		Select s = new Select("*","users","username",username, con);
        ResultSet myRe = s.getResultset();
        if(myRe.next()){
        	return new ConcreteUser(Integer.parseInt(myRe.getString(1)),myRe.getString(2), Integer.parseInt(myRe.getString(3)), myRe.getString(4), myRe.getString(5), myRe.getString(6));
        }
        return null;
	}
	
	public boolean registerUser(String userName, String accesslvl, String pass, String email, String address) throws SQLException{
		/*Insert in = new Insert("users");
		in.addValue(userName, "String");
		in.addValue(accesslvl, "String");
		in.addValue(pass, "String");
		in.addValue(email, "String");
		in.addValue(address, "String");
		//in.executeStatement(SQL, con);
		 */
		return true; 
	}
}