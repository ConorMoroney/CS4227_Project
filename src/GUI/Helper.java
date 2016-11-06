package GUI;
import User.*;
import java.util.ArrayList;
import Database.DatabaseAccess;
/**
 * Created by Paul on 02/11/2016.
 */
public class Helper {
    private static DatabaseAccess dba = DatabaseAccess.getInstance();
    private static Helper help = new Helper();
    private I_Customer cust;
    private I_Employee emp;
    private UserState state;

    private Helper(){

    }

    public UserState getUserState(){
        return state;
    }

    public void setUserState(int access) {
        switch (access) {
            case 1:
                state = new CustomerState();
                break;
            case 2:
                state = new WarehouseState();
                break;
            case 3:
                state = new LogisticsState();
                break;
            case 4:
                state = new ManagerState();
                break;
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

    public Object[] getOrders(){
        return dba.getOrders();
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
}
