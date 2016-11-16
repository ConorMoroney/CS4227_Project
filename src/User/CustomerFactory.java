package User;

/**
 * Created by shane on 28-Oct-16.
 */
public class CustomerFactory extends AbstractUserFactory {


    private String[] concreteUserTypes = {"Customer"};


    @Override
    public ConcreteCustomer createUser(String userType) {
        for (String s : concreteUserTypes) {
            if ("Customer".equalsIgnoreCase(userType)) {
                return new ConcreteCustomer();
            }
        }
        if (userType == null) {
            return null;
        } else {
            return null;
        }
    }
    public String[] getConcreteUserTypes() {
        return concreteUserTypes;
    }

    public void setConcreteUserTypes(String[] concreteUserTypes) {
        this.concreteUserTypes = concreteUserTypes;
    }
}



