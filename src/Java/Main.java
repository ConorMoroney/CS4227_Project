package Java;

import Database.*;
import GUI.*;

public class Main {

	public static void main(String [] args){
		
		// register || log in
		I_Database dbConn = new Database();
		DatabaseAccess dba = DatabaseAccess.getInstance();
		dba.setDbConn(dbConn);
		try {
			dba.connect("jdbc:sqlserver://localhost:49799;database=creationary;integratedSecurity=true;");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainWindow window = new MainWindow();
        PanelFactory panelFac = new PanelFactory();
        PanelManager panelMgr = new PanelManager(panelFac);
        panelMgr.registerObserver(window);
	}
}