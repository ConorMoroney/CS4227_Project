package Java;

import User.ConcreteCustomer;

interface Subject {
	void registerObserver(ConcreteCustomer Customer);
	void removeObserver(ConcreteCustomer Customer);
	void notifyObservers();
}
