package Database;

import java.util.ArrayList;
import Java.I_Product;


/*
 *  Specifies methods that must be implemented by the concrete database class which is specific to the user.
 */
public interface I_Database {
	public ArrayList<I_Product> getItems();
	public ArrayList<I_Product> getItems(String identifier);
	public boolean canUserLogin(String user, String password);
}
