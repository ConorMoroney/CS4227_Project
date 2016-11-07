package SAMPLE1;

import GUI.ActionListenerSuper;
import Java.ConcreteFramework;
import Java.ConcreteInterceptor;
import Database.*;
import GUI.*;

public class Main {
	public static ConcreteFramework c;
	public static GUI.ActionListenerSuper actionListener;
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
		c = new ConcreteFramework();
		actionListener = new ActionListenerSuper();
		ConcreteInterceptor Int1 = new ConcreteInterceptor();
		attach(Int1);
		MainWindow window = new MainWindow();
		PanelFactory panelFac = new PanelFactory();
		PanelManager panelMgr = new PanelManager(panelFac);
		panelMgr.registerObserver(window);
	}
	private static void attach(ConcreteInterceptor i) {
		c.getDispacher().register(i);
	}

}