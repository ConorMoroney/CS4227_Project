
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
