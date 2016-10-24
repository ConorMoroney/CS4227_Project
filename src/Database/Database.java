package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import SQL.*;

import Java.I_Product;

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

	//If Java.user/pass match, log in.
	
	@Override
    public boolean connect(String host, int port, String user, String password) {
		return true;
    }
	
	@Override
    public boolean connect(String connectionURL) throws ClassNotFoundException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//String connectionUrl = "jdbc:sqlserver://localhost:49799;database=creationary;integratedSecurity=true;"  ;
			con = DriverManager.getConnection(connectionURL);  
			
			System.out.println("you are Connected");
			return true;
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("HERE");
			return false;
		
		}
    }
}
