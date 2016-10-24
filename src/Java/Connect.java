package Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

Connection con;	
	
public Connect () throws ClassNotFoundException {

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://localhost:49799;database=Master;integratedSecurity=true;"  ;
			con = DriverManager.getConnection(connectionUrl);  
			
			System.out.println("you are Connected");
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		
		}
	}

 public Connection getconnection()
 {
	return con; 
 }


}
