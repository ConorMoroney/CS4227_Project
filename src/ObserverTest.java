
public class ObserverTest {
	public static void main(String [] args){
		QtyGrabber G = new QtyGrabber();
		
		customer c = new customer();
		
		G.registerObserver(c);
		
		
		G.setQty("bic", 45);
		
		G.removeObserver(c);
	}
}
