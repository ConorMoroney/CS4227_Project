package Java;

public class ProductFactory {

	private String [] concreteTypes = {"pen","pencil","paper","envelope","paperclip","folder", "ruler", "copy"};
	public I_Product createProduct(String productType){
		for (String s:concreteTypes){
			if(s.equalsIgnoreCase(productType)){
				return new ConcreteProduct();
			}
		}

		if(productType == null){
			return null;
		}

		else{
			return null;
		}
	}
	public String[] getConcreteTypes() {
		return concreteTypes;
	}

	public void setConcreteTypes(String[] concreteTypes) {
		this.concreteTypes = concreteTypes;
	}

}
