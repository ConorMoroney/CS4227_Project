package SQL;

import java.sql.*;

/**
 * Created by Conor on 12-Oct-16.
 */
public class Update {

    private Connection con;

    public Update() {}


   /* public boolean UpdateItems(int newAmount , String name , Connection con ) {
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
*/
    public boolean UpdateItems(int newAmount , String name , Connection con ) {
        this.con = con;

        try
        {
            //Java.Connect to database

            Statement mystat = this.con.createStatement();
            String sql = "select * from items WHERE name = '" + name + "'";
            ResultSet myRe = mystat.executeQuery(sql);
            myRe.next();
            int newQuantity = newAmount;
            //update table to have less quantity
            sql = "UPDATE items SET quantity = " + newQuantity + " WHERE name = '" + name + "'";
            mystat.executeUpdate(sql);
            return true;
    }
        catch(Exception exc)
        {
            System.out.println(" couldnt connect to DB 1234 ");
        }
        return false;
    }


}


