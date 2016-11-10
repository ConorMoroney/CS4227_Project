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
    boolean connect(String connectionUrl) throws ClassNotFoundException;
    boolean connect(String host, int port, String user, String password);
    ArrayList<String> getItems();
    ArrayList<I_Product> getItems(String identifier);
    boolean canUserLogin(String user, String password);
    I_Customer getCustomerDetails(String username);
    I_Employee getEmployeeDetails(String username);
    int registerUser(String userName, int accesslvl, String pass, String email, String address);
    int addLog(String logText);
    int getLastID();
    int getAccessLevel(String user);
    ArrayList<String> getStaffDetails();
    boolean addOrder(String name, int quantity, String customer);
    boolean updateItemQuantity(int decider, int quantity, String name);
    ArrayList<String> getOrders();
}
