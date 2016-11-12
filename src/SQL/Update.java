package SQL;

import GUI.Helper;
import Momento.CareTaker;
import Momento.Originator;

import java.sql.*;

/**
 * Created by Conor on 12-Oct-16.
 */
public class Update {
    private final Originator originator = new Originator();
    private final CareTaker careTaker = new CareTaker();

    public Update() {

    }

    public boolean UpdateItems(int decider, int newAmount , String name , Connection con ) {


        Connection con1 = con;

        try
        {
            //Java.Connect to database

            int i = Helper.getInstance().getDecider();
            Statement mystat = con1.createStatement();
            String sqlCurrent = "select * from items WHERE name = '" + name + "'";
            String sqlToExecuteOnUndo = "";
            String sqlToExecuteOnPurchase= "";


            ResultSet myRe = mystat.executeQuery(sqlCurrent);
            myRe.next();
            int newQuantity = newAmount;
            sqlCurrent = "UPDATE items SET quantity = " + newQuantity + " WHERE name = '" + name + "'";

            int prevAmount = myRe.getInt(7);

            sqlToExecuteOnPurchase = "UPDATE items SET quantity = " + newQuantity+ " WHERE name = '" + name + "'";
            sqlToExecuteOnUndo = "UPDATE items SET quantity = " + prevAmount+ " WHERE name = '" + name + "'";

            originator.setState(sqlToExecuteOnUndo);
            originator.setState(sqlToExecuteOnPurchase);
            careTaker.add(originator.saveStateToMemento());

            if (i==1){
                originator.getStateFromMemento(careTaker.get(0));
                mystat.executeUpdate(sqlToExecuteOnPurchase);
            }
            else if (i==2){

                originator.getStateFromMemento(careTaker.get(0));
                mystat.executeUpdate(sqlToExecuteOnPurchase);
            }


            mystat.executeUpdate(sqlCurrent);
            return true;
        }
        catch(Exception exc)
        {
            System.out.println(" couldnt connect to DB 1234 ");
        }
        return false;
    }
}
