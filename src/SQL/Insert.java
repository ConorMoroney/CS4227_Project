package SQL;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Conor on 12-Oct-16.
 */
public class Insert {

    Connection con;

    public Insert() throws ClassNotFoundException {
        Connect c = new Connect();
        con = c.getconnection();
    }


    /**************
     * Adding Creation methods for insert
     *
     * *************/

    public void CreateUserInsert(int iduser , String username , int accesslvl , String password , String email , String address , Connection con)
    {

        try {


            String SQL ="INSERT INTO [dbo].[users]([idusers],[username],[accesslvl],[password],[email],[address])VALUES"
                    + "(?,?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(SQL);
            preparedStmt.setInt (1, iduser);
            preparedStmt.setString (2, username);
            preparedStmt.setInt (3, accesslvl);
            preparedStmt.setString (4, password);
            preparedStmt.setString (5, email);
            preparedStmt.setString (6, address);
            System.out.print(SQL);
            preparedStmt.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Connection failed");
            System.out.println(e.getMessage());
        }

    }

    public void CreateProductInsert(int iditem , String type , String name , String description, float price, float weight,int quanitiy , Connection con)
    {

        try {


            String SQL ="INSERT INTO [dbo].[items]([iditems],[type],[name],[description],[price],[weight],[quantity])VALUES"
                    + "(?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(SQL);
            preparedStmt.setInt (1, iditem);
            preparedStmt.setString (2, type);
            preparedStmt.setString (3, name);
            preparedStmt.setString (4, description);
            preparedStmt.setFloat (5, price);
            preparedStmt.setFloat (6, weight);
            preparedStmt.setFloat (7, quanitiy);
            System.out.print(SQL);
            preparedStmt.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Connection failed");
            System.out.println(e.getMessage());
        }

    }


    public Connection getConnection()
    {
        return con;
    }


}
