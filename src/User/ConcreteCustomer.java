package User;

import Java.Observer;

public class ConcreteCustomer implements Observer, I_Customer {

    private String name;
    private int id;
    private String password;
    private String email;
    private String address;
    private int accesslvl =1;
    private I_UserState state;

    public ConcreteCustomer(int ID, String user, int access, String pass, String mail, String add){
        id = ID;
        name = user;
        accesslvl = access;
        password = pass;
        email = mail;
        address = add;
    }

    public ConcreteCustomer() {
        accesslvl = 1;
    }


    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;
    }

    @Override
    public void setType(String type) {

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
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }
    public int getID() {
        // TODO Auto-generated method stub
        return id;
    }
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }
    public String getEmail() {
        // TODO Auto-generated method stub
        return email;
    }
    public String getAddress() {
        // TODO Auto-generated method stub
        return address;
    }


    @Override
    public void update(int qty , String item) {
        // TODO Auto-generated method stub
        System.out.println(item +  " is now back in stock \n We now have " + qty + "in stock");
    }

    public String getname() {
        return name;
    }

    @Override
    public void setaccesslvl(int a){
        accesslvl = a;
    }
}
