package Java;

public class UserFactory {

	public I_User createUser(String userType){

		if(userType == null){
			return null;
		}
		else if("customer".equalsIgnoreCase(userType)){
			return new customer();
		}
		else if("LogisticsStaff".equalsIgnoreCase(userType)){
			return new logisticsStaff();
		}
		else if("warehouseStaff".equalsIgnoreCase(userType)){
			return new wareHouseStaff();
		}
		else if("manager".equalsIgnoreCase(userType)){
			return new Manager();
		}

		return null;
	}
}

/*package Java;

public class UserFactory {

	public I_User createUser(String userType){
		String [] concreteUserTypes = {"warehouse","logistics","manager","customer"};
		for(String s:concreteUserTypes){
			if (s.equalsIgnoreCase(userType)) {
				return new ConcreteUser();
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
}*/



