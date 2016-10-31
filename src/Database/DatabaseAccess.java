package Database;

import java.util.ArrayList;

import Java.I_Product;
import User.I_Customer;

/*
 * Singleton that is used to call the concrete implementation of the database communication class
 */

public class DatabaseAccess implements I_Database {
    private static DatabaseAccess dba = new DatabaseAccess();
    private I_Database dbconn;
    
    private DatabaseAccess(){
    	
    }
    
    public static DatabaseAccess getInstance(){
    	return dba;
    }
    
    public void setDbConn(I_Database dbc){
    	dbconn = dbc;
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
    public void getItems(){
    	dbconn.getItems();
    }
   
    @Override
    public ArrayList<I_Product> getItems(String identifier){
    	return dbconn.getItems(identifier);
    }
    
    @Override
    public boolean canUserLogin(String user, String password){
    	return dbconn.canUserLogin(user, password);
    }
    
    @Override
    public I_Customer getUserDetails(String username){
    	return dbconn.getUserDetails(username);
    }
    
    @Override
    public boolean registerUser(int id, String userName, int accesslvl, String pass, String email, String address){
    	return dbconn.registerUser(id, userName, accesslvl, pass, email, address);
    }
    
    @Override
    public int getLastID(){
    	return dbconn.getLastID();
    }
    
    @Override
    public Object[] getOrders(){
    	return dbconn.getOrders();
    }
}