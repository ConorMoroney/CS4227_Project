
package Java;

public class UserFactory {
	public I_User createUser(String userType){
		String [] concreteUserTypes = {"warehouse","logistics","manager"};
		for(String s:concreteUserTypes){
			if (s.equalsIgnoreCase(userType)) {
				return new ConcreteUser();
			}
			else if("customer".equalsIgnoreCase(userType)){
				return new customer();
			}


		}
		if(userType==null){
			return null;
		}
		else{
			System.out.println("This is not a valid user type.");
			return null;
		}
	}
}



