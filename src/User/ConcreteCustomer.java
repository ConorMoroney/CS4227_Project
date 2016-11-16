package User;

import Java.Observer;

import javax.swing.*;

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
        this.name = name;
    }

    @Override
    public void setType(String type) {

    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public int getaccesslvl() {
        return accesslvl;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
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
    public void update(int qty , String item) {
        System.out.println(item +  " is now back in stock \n We now have " + qty + "in stock");
        JOptionPane.showMessageDialog(null, item +  " is now back in stock \n We now have " + qty + "in stock");
    }

    @Override
    public void setaccesslvl(int a){
        accesslvl = a;
    }
}
