package Java;

import User.ConcreteCustomer;

public interface Subject {
	void registerObserver(ConcreteCustomer Customer);
	void removeObserver(ConcreteCustomer Customer);
	void notifyObservers();
}
