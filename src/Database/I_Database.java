package Database;

import java.sql.SQLException;
import java.util.ArrayList;
import Java.I_Product;
import Java.I_User;


/*
 *  Specifies methods that must be implemented by the concrete database class which is specific to the user.
 */
public interface I_Database {
	public boolean connect(String connectionUrl) throws ClassNotFoundException;
	public boolean connect(String host, int port, String user, String password);
	public void getItems() throws SQLException;
	public ArrayList<I_Product> getItems(String identifier);
	public boolean canUserLogin(String user, String password) throws SQLException;
	public I_User getUserDetails(String username) throws SQLException;
	public boolean registerUser(int id, String userName, int accesslvl, String pass, String email, String address) throws SQLException;
	public int getLastID() throws SQLException;
	public Object[] getOrders() throws SQLException;
}