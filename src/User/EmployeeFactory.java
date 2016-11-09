
package User;

public class EmployeeFactory extends AbstractUserFactory {


    public ConcreteEmployee createUser(String userType){
        String [] concreteUserTypes = {"warehouse","logistics","manager"};
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
            System.out.println("This is not a valid employee type.");
            return null;
        }
    }
}



