package SQL;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Conor on 12-Oct-16.
 */
public class Insert {

    Connection con;

    public Insert() {
        //Connect c = new Connect();
        //con = c.getconnection();
    }


    /**************
     * Adding Creation methods for insert
     *
     * *************/

    public boolean CreateUserInsert( String username , int accesslvl , String password , String email , String address , Connection con)
    {
        String table = "users";
        this.con = con;
        int id = getMaxId(table);
        if (id > 0) {
            try {
                id++;


                String SQL = "INSERT INTO [dbo].[users]([idusers],[username],[accesslvl],[password],[email],[address])VALUES"
                        + "(?,?,?,?,?,?)";
                PreparedStatement preparedStmt = con.prepareStatement(SQL);
                preparedStmt.setInt(1, id);
                preparedStmt.setString(2, username);
                preparedStmt.setInt(3, accesslvl);
                preparedStmt.setString(4, password);
                preparedStmt.setString(5, email);
                preparedStmt.setString(6, address);
                System.out.print(SQL);
                preparedStmt.executeUpdate();
                return true;


            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Connection failed");
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public void CreateProductInsert( String type , String name , String description, float price, float weight,int quanitiy , Connection con)
    {
        String table = "items";
        int id = getMaxId(table);
        if (id > 0) {
        try {



            String SQL ="INSERT INTO [dbo].[items]([iditems],[type],[name],[description],[price],[weight],[quantity])VALUES"
                    + "(?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(SQL);
            preparedStmt.setInt (1, id);
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
    }


    public Connection getConnection()
    {
        return con;
    }

    private int getMaxId(String table)
    {
        String coloumn;
        if( table.equalsIgnoreCase("users"))
        coloumn = "idusers";
        else
            coloumn = "iditems";

      SelectMax s = new SelectMax(coloumn,table, con);
      ResultSet r = s.getResultset();
        try {
            while (r.next()){
                return r.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
