package User;

/**
 * Created by shane on 28-Oct-16.
 */
public class CustomerFactory extends AbstractUserFactory {
    @Override
    public ConcreteCustomer createUser(String userType) {
        String[] concreteUserTypes = {"Customer"};
        for (String s : concreteUserTypes) {
            if ("Customer".equalsIgnoreCase(userType)) {
                return new ConcreteCustomer();
            }
        }
        if (userType == null) {
            return null;
        } else {
            System.out.println("This is not a valid Customer type.");
            System.out.println(userType + "B+++++++");
            return null;
        }
    }
}



