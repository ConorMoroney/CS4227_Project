
public interface Subject {
	public void registerObserver(customer Customer );
	public void removeObserver(customer Customer );
	public void notifyObservers();		
}
