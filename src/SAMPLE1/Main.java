package SAMPLE1;

import GUI.ActionListenerSuper;
import GUI.LogInScreenGUI;
import Java.ConcreteFramework;
import Java.ConcreteInterceptor;

public class Main {

	public static ConcreteFramework c;
	public static GUI.ActionListenerSuper actionListener;
	public static void main(String [] args){
		
		// register || log in
		c = new ConcreteFramework();
		actionListener = new ActionListenerSuper();
		ConcreteInterceptor Int1 = new ConcreteInterceptor();
		attach(Int1);
		LogInScreenGUI.main(null);
		
		
		
		//display GUI for different Java.user access
		//do stuff from different GUI
			//log out 
		
	}
	private static void attach(ConcreteInterceptor i){
		 c.getDispacher().register(i);

	}
}