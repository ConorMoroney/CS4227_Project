package Database;
import User.*;
import java.util.ArrayList;
import java.util.List;
import Java.I_Product;
/**
 * Created by Paul on 02/11/2016.
 */
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
    public ArrayList<String> getItems(){
        return dbconn.getItems();
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
    public I_Customer getCustomerDetails(String username){
        return dbconn.getCustomerDetails(username);
    }

    @Override
    public I_Employee getEmployeeDetails(String username){
        return dbconn.getEmployeeDetails(username);
    }

    @Override
    public int registerUser(String userName, int accesslvl, String pass, String email, String address){
        return dbconn.registerUser(userName, accesslvl, pass, email, address);
    }

    @Override
    public int getLastID(){
        return dbconn.getLastID();
    }


    @Override
    public int getAccessLevel(String user){
        return dbconn.getAccessLevel(user);
    }

    @Override
    public ArrayList<String> getStaffDetails(){
        return dbconn.getStaffDetails();
    }

    @Override
    public boolean addOrder(String name,  int quantity, String customer){
        return dbconn.addOrder(name, quantity, customer);
    }

    @Override
    public boolean updateItemQuantity(int quantity, String name){
        return dbconn.updateItemQuantity(quantity, name);
    }

    @Override
    public ArrayList<String> getOrders(){
        return dbconn.getOrders();
    }
}
