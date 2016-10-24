package Database;

import java.sql.SQLException;
import java.util.ArrayList;

import Java.I_Product;

/*
 * Singleton that is used to call the concrete implementation of the database communication class
 */

public class DatabaseAccess implements I_Database {
    private I_Database dbconn;
    private static DatabaseAccess dba = new DatabaseAccess();
    
    private DatabaseAccess(){
    	
    }
    
    public void setDbConn(I_Database dbc){
    	dbconn = dbc;
    }
    
    public static DatabaseAccess getInstance(){
    	return dba;
    }
    
    @Override
    public boolean connect(String host, int port, String user, String password) {
    	return dbconn.connect(host, port, user, password);
    }
    
    @Override
    public boolean connect(String connectionURL) throws ClassNotFoundException{
    	return dbconn.connect(connectionURL);
    }
    
    @Override
    public ArrayList<I_Product> getItems(){
    	return dbconn.getItems();
    }
   
    @Override
    public ArrayList<I_Product> getItems(String identifier){
    	return dbconn.getItems(identifier);
    }
    
    @Override
    public boolean canUserLogin(String user, String password) throws SQLException{
    	return dbconn.canUserLogin(user, password);
    }
}
