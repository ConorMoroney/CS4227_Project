import java.util.ArrayList;

public class Product implements Subject {
	private String productName;
	private boolean available;
	
	private ArrayList<Observer> listOfObservers = new ArrayList<Observer>();
	
	
	/*
	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		listOfObservers.add(observer);
		
	}
	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		listOfObservers.remove(observer);
		
	}*/
	
	
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		System.out.println("Notifying all registered customers, when product is available");
		for(Observer observer : listOfObservers){
			observer.update(listOfObservers.size(),productName);
		}
	}
	public ArrayList<Observer> getListOfObservers() {
		return listOfObservers;
	}
	public void setListOfObservers(ArrayList<Observer> listOfObservers) {
		this.listOfObservers = listOfObservers;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
		if(available == true){
			notifyObservers();
		}
	}
	@Override
	public void registerObserver(customer Customer) {
		// TODO Auto-generated method stub
		listOfObservers.add(Customer);
	}
	@Override
	public void removeObserver(customer Customer) {
		// TODO Auto-generated method stub
		listOfObservers.remove(Customer);
		
	}


}
