package Database;
import java.util.ArrayList;
import Java.I_Product;
import User.*;
/**
 * Created by Paul on 02/11/2016.
 */
/*
 *  Specifies methods that must be implemented by the concrete database class which is specific to the user.
 */
public interface I_Database {
    public boolean connect(String connectionUrl) throws ClassNotFoundException;
    public boolean connect(String host, int port, String user, String password);
    public ArrayList<String> getItems();
    public ArrayList<I_Product> getItems(String identifier);
    public boolean canUserLogin(String user, String password);
    public I_Customer getCustomerDetails(String username);
    public I_Employee getEmployeeDetails(String username);
    public int registerUser(String userName, int accesslvl, String pass, String email, String address);
    public int addLog(String logText);
    public int getLastID();
    public int getAccessLevel(String user);
    public ArrayList<String> getStaffDetails();
    public boolean addOrder(String name,  int quantity, String customer);
    public boolean updateItemQuantity(int quantity, String name);
    public ArrayList<String> getOrders();
}
