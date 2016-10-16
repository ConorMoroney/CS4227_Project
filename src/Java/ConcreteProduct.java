package Java;

/**
 * Created by shane on 16-Oct-16.
 */
public class ConcreteProduct implements I_Product {
    private int ID;
    private String description;
    private double price;
    private double weight;
    private int quantity;
    private String name;
    @Override
    public void setName(String name) {
        this.name=name;
        System.out.print(name);
    }

    @Override
    public void setID(int ID) {
        this.ID=ID;
    }

    @Override
    public void setDescription(String description) {
        this.description=description;
    }

    @Override
    public void setPrice(double price) {
        this.price=price;
    }

    @Override
    public void setWeight(double weight) {
        this.weight=weight;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }
}
