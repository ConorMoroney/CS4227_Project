package Database;

/**
 * Created by Paul on 02/11/2016.
 */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import SQL.*;
import User.*;

import Java.I_Product;

/*Concrete database class using Microsoft SQL Server for testing and out of the box functionality
 */

public class Database implements I_Database {
    Connection con;

    @Override
    public ArrayList<String> getItems() {
        ArrayList<String> items = new ArrayList<String>();
        try{
            Statement mystat = con.createStatement();
            ResultSet myRe = mystat.executeQuery("select * from items");
            while (myRe.next())
            {
                items.add(myRe.getString(3) + ": " + myRe.getString(5));

            }
        }
        catch(SQLException e){
            System.out.println("Error retrieving items from database");
        }
        return items;

    }

    @Override
    public ArrayList<I_Product> getItems(String identifier) {
        return null;
    }

    @Override
    public boolean canUserLogin(String user, String password){
        try{
            Select s = new Select("*","users","username",user, con);
            ResultSet myRe = s.getResultset();
            if(myRe.next()){
                String dbPass = myRe.getString(4);
                if (dbPass.equals(password)){
                    return true;
                }
            }
        }
        catch(SQLException e){
            System.out.println("Error logging user in");
        }
        return false;
    }

    @Override
    public boolean connect(String host, int port, String user, String password) {
        return true;
    }

    @Override
    public boolean connect(String connectionURL) throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionURL);

            System.out.println("you are Connected");
            return true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            return false;

        }
    }

    @Override
    public I_Customer getCustomerDetails(String username){
        try{
            Select s = new Select("*","users","username",username, con);
            ResultSet myRe = s.getResultset();
            if(myRe.next()){
                return new ConcreteCustomer(Integer.parseInt(myRe.getString(1)),myRe.getString(2), Integer.parseInt(myRe.getString(3)), myRe.getString(4), myRe.getString(5), myRe.getString(6));
            }
        }
        catch(SQLException e){
            System.out.println("Error getting user object from database");
        }
        return null;
    }

    @Override
    public I_Employee getEmployeeDetails(String username){
        try{
            Select s = new Select("*","users","username",username, con);
            ResultSet myRe = s.getResultset();
            if(myRe.next()){
                return new ConcreteEmployee(Integer.parseInt(myRe.getString(1)),myRe.getString(2), Integer.parseInt(myRe.getString(3)), myRe.getString(4), myRe.getString(5), myRe.getString(6));
            }
        }
        catch(SQLException e){
            System.out.println("Error getting user object from database");
        }
        return null;
    }

    public boolean registerUser(String userName, int accesslvl, String pass, String email, String address){
            Insert i = new Insert();
            return i.CreateUserInsert(userName, accesslvl, pass, email, address, con);
    }

    public int getLastID(){
        try{
            SelectMax s = new SelectMax("idusers", "users", con);
            ResultSet myRe = s.getResultset();
            while (myRe.next()){
                return myRe.getInt(1);
            }

        }
        catch(SQLException e){
            System.out.println("Error retrieving last id from database");
        }
        return -1;
    }

    public Object[] getOrders(){
        Object[] listData;
        int i = 0;
        try
        {
            Statement mystat = con.createStatement();
            ResultSet myRe = mystat.executeQuery("select * from items");
            //get db data
            while (myRe.next()){
                i++;
            }

        }
        catch(Exception exc)
        {
            System.out.println("Database error");
        }
        listData = new Object[i];

        i = 0;
        try
        {
            Statement mystat = con.createStatement();
            ResultSet myRe = mystat.executeQuery("select * from orderqueue");

            String name = "";
            String qty = "";
            String customer = "";

            //get db data
            while (myRe.next())
            {
                name = "Product Name: " + myRe.getString(1) + ", ";
                qty = "Quantity:  " +  myRe.getInt(2) + ", ";
                customer = "Customer:  " +  myRe.getString(3) + ", ";

                listData[i] =name + qty + customer;

                i++;
            }
        }
        catch(Exception exc)
        {
            System.out.println("Database error");
        }
        return listData;
    }

    public int getAccessLevel(String user) {
        try {
            Select s = new Select("*","users","username",user, con);
            ResultSet myRe = s.getResultset();
            if(myRe.next()) {
                return Integer.parseInt(myRe.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
        return -1;
    }

    public ArrayList<String> getStaffDetails(){
        ArrayList<String> staff = new ArrayList<String>();
        try{
        Select s = new Select("select * from users where accesslvl = 2 or accesslvl = 3", con);
        ResultSet myRe = s.getResultset();
        while (myRe.next()) {
            String occupancy = "";
            int accesslvl = myRe.getInt(3);
            if (accesslvl == 2)
                occupancy = "Employee Type: WareHouse Staff, \n";
            else
                occupancy = "Employee Type: Logistics Staff, \n";


            staff.add(" UserName: " + myRe.getString(2) + ", \n" + "Occupancy: " + occupancy + "\n" +  " Address:  " + myRe.getString(6) + ", \n" + " Email: " + myRe.getString(5) + ", \n\n");
        }
        }catch(SQLException e){
            System.out.println(e.fillInStackTrace());
        }
        return staff;
    }

}