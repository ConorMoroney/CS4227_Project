package SQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect{

	private Connection con;

	public Connect() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://localhost;database=Creationary;integratedSecurity=true;"  ;
			con = DriverManager.getConnection(connectionUrl);

		} catch (Exception e) {
			System.out.println("Connection failed");
			System.out.println(e.getMessage());
		}
	}
	public Connection getconnection()
	{
		return con;
	}
}


