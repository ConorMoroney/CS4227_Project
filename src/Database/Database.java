package Database;

import java.util.ArrayList;

import Java.I_Product;

public class Database implements I_Database {

	@Override
	public ArrayList<I_Product> getItems() {
		return null;
	}

	@Override
	public ArrayList<I_Product> getItems(String identifier) {
		return null;
	}
	
	@Override
	public boolean canUserLogin(String user, String password){
		return true;
	}
}
