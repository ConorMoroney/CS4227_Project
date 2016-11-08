package User;

/**
 * Created by shane on 21-Oct-16.
 */
public class ConcreteEmployee implements I_Employee{

    private String name;
    private int id;
    private String [] concreteTypes = {"Warehouse", "Logistics", "Manager"};
    //Customer access level will always be the lowest
    //The higher the index in the concreteTypesArray the higher the access level
    private int accesslvl= 0;
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;

    }

    @Override
    public void setType(String type) {
        for(int i = 0; i<concreteTypes.length;i++){
            if (type.equalsIgnoreCase(concreteTypes[i])){
                accesslvl = i+2;
            }
        }

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
    public int getID() {
        return id;
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
