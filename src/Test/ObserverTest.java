package Test.DatabaseTests;

import Java.QtyGrabber;
import User.ConcreteCustomer;

class ObserverTest {
	public static void main(String [] args){
		QtyGrabber G = new QtyGrabber();

		ConcreteCustomer c = new ConcreteCustomer();
		
		G.registerObserver(c);

		G.setQty("bic", 45);
		
		G.removeObserver(c);
	}
}
