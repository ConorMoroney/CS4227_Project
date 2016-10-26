package Java;

public class ProductFactory {
	
	public I_Product createProduct(String productType){
		String [] concreteTypes = {"pen","pencil","paper","envelope","paperclip","folder", "ruler", "copy"};
		for (String s:concreteTypes){
			if(s.equalsIgnoreCase(productType)){
				return new ConcreteProduct();
			}
		}
		if(productType == null){
			return null;
		}

		else{
			System.out.println("This is not a product type");
			return null;
		}
	}

}
