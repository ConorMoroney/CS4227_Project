package SAMPLE1;

import Database.Database;
import Database.DatabaseAccess;
import Database.I_Database;
import GUI.*;
import Java.ConcreteInterceptor;

import static GUI.MainWindow.c;

public class Main {
	//public static ConcreteFramework c;
	//public static GUI.ActionListenerSuper actionListener;
	public static void main(String [] args){

		// register || log in
		I_Database dbConn = new Database();
		DatabaseAccess dba = DatabaseAccess.getInstance();
		dba.setDbConn(dbConn);
		try {
			dba.connect("jdbc:sqlserver://localhost;database=Creationary;integratedSecurity=true;");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//c = new ConcreteFramework();
		//actionListener = new ActionListenerSuper();

		SplashWindow splashWindow = new SplashWindow();
		MainWindow window = new MainWindow();
		PanelFactory panelFac = new PanelFactory();
		PanelManager panelMgr = new PanelManager(panelFac);
		panelMgr.registerObserver(window);
		ConcreteInterceptor Int1 = new ConcreteInterceptor();
		attach(Int1);

	}

	private static void attach(ConcreteInterceptor i) {
		c.getDispacher().register(i);
	}



}