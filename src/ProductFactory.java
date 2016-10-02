
public class ProductFactory {
	
	public I_Product createProduct(String productType){
		
		if(productType == null){
			return null;
		}
		else if("pen".equalsIgnoreCase(productType)){
			return new Pen();
		}
		else if("pencil".equalsIgnoreCase(productType)){
			return new pencil();
		}
		else if("paper".equalsIgnoreCase(productType)){
			return new Paper();
		}
		else if("envelope".equalsIgnoreCase(productType)){
			return new Envelope();
		}
		else if("paperclip".equalsIgnoreCase(productType)){
			return new PaperClip();
		}
		else if("folder".equalsIgnoreCase(productType)){
			return new Folder();
		}
		else if("ruler".equalsIgnoreCase(productType)){
			return new Ruler();
		}
		else if("copy".equalsIgnoreCase(productType)){
			return new Copy();
		}
		else{
			System.out.println("this is not a product type");
			return null;
		}
	}

}
