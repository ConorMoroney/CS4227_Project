package Java;

/**
 * Created by shane on 16-Oct-16.
 */
public class ConcreteProduct implements I_Product {

    @Override
    public void setName(String name) {
        String name1 = name;
        System.out.print(name);
    }

    @Override
    public void setID(int ID) {
        int ID1 = ID;
    }

    @Override
    public void setDescription(String description) {
        String description1 = description;
    }

    @Override
    public void setPrice(double price) {
        double price1 = price;
    }

    @Override
    public void setWeight(double weight) {
        double weight1 = weight;
    }

    @Override
    public void setQuantity(int quantity) {
        int quantity1 = quantity;
    }
}
