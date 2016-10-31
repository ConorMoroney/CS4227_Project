package User;

/**
 * Created by shane on 28-Oct-16.
 */
public class FactoryProducer {
    public static AbstractUserFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Customer"))
            return new CustomerFactory();
        else if(choice.equalsIgnoreCase("Employee")){
            return new EmployeeFactory();
        }
        return null;
    }
}
