package Database;

import java.sql.SQLException;
import java.util.ArrayList;
import Java.I_Product;


/*
 *  Specifies methods that must be implemented by the concrete database class which is specific to the user.
 */
public interface I_Database {
	public boolean connect(String connectionUrl) throws ClassNotFoundException;
	public boolean connect(String host, int port, String user, String password);
	public ArrayList<I_Product> getItems();
	public ArrayList<I_Product> getItems(String identifier);
	public boolean canUserLogin(String user, String password) throws SQLException;
}
