package Java;

/**
 * Created by shane on 21-Oct-16.
 */
public class ConcreteUser implements I_User{

    private String name;
    private String id;
    private String password;
    private String email;
    private String address;
    private String accesslvl;


    public ConcreteUser(String ID, String user, String access, String pass, String mail, String add){
    	id = ID;
    	name = user;
    	accesslvl = access;
    	password = pass;
    	email = mail;
    	address = add;
    }
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;

    }

    @Override
    public void setID(String id) {
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
    public String getaccesslvl() {
        return accesslvl;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getEmail() {
        return email;
    }
    
    @Override
    public String getAddress() {
        return address;
    }
    
    @Override
    public String getPassword() {
        return password;
    }
	@Override
	public String getID() {
		return id;
	}






}
