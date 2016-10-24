package Java;

public interface Subject {
	void registerObserver(customer Customer);
	void removeObserver(customer Customer);
	void notifyObservers();
}
