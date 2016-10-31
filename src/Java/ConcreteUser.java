package Java;

/**
 * Created by shane on 21-Oct-16.
 */
public class ConcreteUser implements I_User{

    private String name;
    private int id;
    private String password;
    private String email;
    private String address;
    private int accesslvl;
    private int customer = 1;
    private int warehouse = 2;
    private int logistics = 3;
    private int manager = 4;
    private UserState state;

    public ConcreteUser(int ID, String user, int access, String pass, String mail, String add){
    	id = ID;
    	name = user;
    	accesslvl = access;
    	password = pass;
    	email = mail;
    	address = add;
    }
    
    public ConcreteUser(){
    	
    }
    
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;

    }

    @Override
    public void setType(String type) {
        accesslvl=1;
        //Make this a dropdown pls
        //Set of variable - each variable sets access lvl

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
        return accesslvl;
    }

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
	
	public void setUserState(int s){
		switch(s){
		case 1:
			state = new CustomerState();
			break;
		case 2:
			state = new WarehouseState();
			break;
		}
	}
	public UserState getUserState(){
		return state;
	}






}
