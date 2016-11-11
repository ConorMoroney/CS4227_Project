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
   /*
   public boolean UpdateItems(int newAmount , String name , Connection con ) {
        this.con = con;
        try {


            String SQL = "UPDATE [dbo].[items] SET [quantity] = ? WHERE name = ?";

            PreparedStatement preparedStmt = this.con.prepareStatement(SQL);
            preparedStmt.setInt(1, newAmount);
            preparedStmt.setString(2, name);
            System.out.println(SQL);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
<<<<<<< HEAD
*/
    public boolean UpdateItems(int decider, int newAmount , String name , Connection con ) {


        Connection con1 = con;

        try
        {
            //Java.Connect to database

            int plswork = Helper.getInstance().getDecider();
            System.out.println("------------------" + plswork + "------------------");


            Statement mystat = con1.createStatement();
            String sqlCurrent = "select * from items WHERE name = '" + name + "'";
            String sqlToExecuteOnUndo = "";
            String sqlToExecuteOnPurchase= "";
            ResultSet myRe = mystat.executeQuery(sqlCurrent);
            myRe.next();
            int newQuantity = newAmount;
            //update table to have less quantity
            sqlCurrent = "UPDATE items SET quantity = " + newQuantity + " WHERE name = '" + name + "'";
            System.out.println(newQuantity + "---------" );
            System.out.println(name + "++++++++++++" );
            int prevAmount = myRe.getInt(7);
            System.out.println("///////////////////////////" + prevAmount);





            sqlToExecuteOnPurchase = "UPDATE items SET quantity = " + newQuantity+ " WHERE name = '" + name + "'";

            sqlToExecuteOnUndo = "UPDATE items SET quantity = " + prevAmount+ " WHERE name = '" + name + "'";

            originator.setState(sqlToExecuteOnUndo);

            originator.setState(sqlToExecuteOnPurchase);

            careTaker.add(originator.saveStateToMemento());

            if (plswork==1){

                originator.getStateFromMemento(careTaker.get(0));
                System.out.println("Second saved State: " + originator.getState());

                System.out.println("------------------" + plswork + "------------------");
                mystat.executeUpdate(sqlToExecuteOnPurchase);
            }
            else if (plswork==2){

                originator.getStateFromMemento(careTaker.get(0));

                System.out.println("First saved State: " + originator.getState());


                System.out.println("------------------" + plswork + "------------------");
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
