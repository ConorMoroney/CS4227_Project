package GUI;
import User.*;
import java.util.ArrayList;
import Database.DatabaseAccess;
/**
 * Created by Paul on 02/11/2016.
 */
public class Helper {
    private static final DatabaseAccess dba = DatabaseAccess.getInstance();
    private static final Helper help = new Helper();
    private I_Customer cust;
    private I_Employee emp;
    private I_UserState state;

    public int getDecider() {
        return decider;
    }

    public void setDecider(int decider) {
        this.decider = decider;
    }

    private int decider = 0;

    private Helper(){

    }

    public I_UserState getUserState(){
        return state;
    }

    private void setUserState(int access) {
        if(access==1) {
            state = new CustomerState();
        }
        else if (access>1){
            state = new EmployeeState(emp.getName());
        }
    }


    public static Helper getInstance(){
        return help;
    }

    public boolean canUserLogin(String user, String password){
        return dba.canUserLogin(user, password);
    }

    public void getCustomerDetails(String username){
        cust = dba.getCustomerDetails(username);
        setUserState(cust.getaccesslvl());
    }


    public void getEmployeeDetails(String username){
        emp = dba.getEmployeeDetails(username);
        setUserState(emp.getaccesslvl());
    }


    public I_Customer getCustomer(){
        return cust;
    }

    public I_Employee getEmployee(){
        return emp;
    }

    public void logoutUser(){
        cust = null;
        emp = null;
    }

    public ArrayList<String> getItems(){
        return dba.getItems();
    }

    public int getLastID(){
        return dba.getLastID();
    }

    public int registerUser(String userName, int accesslvl, String pass, String email, String address){
        return dba.registerUser(userName, accesslvl, pass, email, address);
    }

    public int getAccessLevel(String user){
        return dba.getAccessLevel(user);
    }

    public ArrayList<String> getStaffDetails(){
        return dba.getStaffDetails();
    }

    public void setCustomer(I_Customer c){
        c.setaccesslvl(getAccessLevel(c.getName()));
        cust = c;
        setUserState(cust.getaccesslvl());
    }

    public void setEmployee(I_Employee em){
        emp = em;
        setUserState(emp.getaccesslvl());
    }

    public boolean addOrder(String name,  int quantity, String customer){
        return dba.addOrder(name, quantity, customer);
    }

    public boolean updateItemQuantity(int decider,  int quantity, String name){
        return dba.updateItemQuantity(decider, quantity, name);
    }

    public ArrayList<String> getOrders(){
        return dba.getOrders();
    }
}
