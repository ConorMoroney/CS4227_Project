package Database;

import java.util.ArrayList;
import Java.I_Product;
import User.I_Customer;


/*
 *  Specifies methods that must be implemented by the concrete database class which is specific to the user.
 */
public interface I_Database {
	public boolean connect(String connectionUrl) throws ClassNotFoundException;
	public boolean connect(String host, int port, String user, String password);
	public void getItems();
	public ArrayList<I_Product> getItems(String identifier);
	public boolean canUserLogin(String user, String password);
	public I_Customer getUserDetails(String username);
	public boolean registerUser(int id, String userName, int accesslvl, String pass, String email, String address);
	public int getLastID();
	public Object[] getOrders();
}