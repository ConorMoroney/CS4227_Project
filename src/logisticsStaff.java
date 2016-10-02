public class logisticsStaff extends Staff{

	private int accesslvl = 3;
	private String name;
	private int id;
	private String password;
	private String email;
	private String address;
	
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void setID(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		this.address = address;
	}

	@Override
	public int getaccesslvl() {
		// TODO Auto-generated method stub
		return accesslvl;
	}
}