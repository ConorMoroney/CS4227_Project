
package User;

public class EmployeeFactory extends AbstractUserFactory {
    private String [] concreteUserTypes = {"warehouse","logistics","manager"};
    public ConcreteEmployee createUser(String userType){
        for(String s:concreteUserTypes){
            if (s.equalsIgnoreCase(userType)) {
                return new ConcreteEmployee();
            }
            if ("ConcreteEmployee".equalsIgnoreCase(userType)) {
                return new ConcreteEmployee();
            }
        }
        if(userType==null){
            return null;
        }
        else{
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
