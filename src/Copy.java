
public class Copy implements I_Product{
	
	private int ID;
	private String description;
	private double price;
	private double weight;
	private int quantity;
	private String name;
	
	@Override
	public void setID(int ID) {
		
		this.ID = ID;
		System.out.println(ID);
	}

	@Override
	public void setDescription(String description) {
		
		this.description =description;
		System.out.println(description);
	}

	@Override
	public void setPrice(double price) {
		
		this.price = price;
		System.out.println(price);
	}

	@Override
	public void setWeight(double weight) {
		
		this.weight = weight;
		System.out.println(weight);
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		System.out.println(quantity);
	}

	@Override
	public void setName(String name) {
		this.name = name;
		System.out.println(name);
	}
}
