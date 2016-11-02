package SQL;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Conor on 12-Oct-16.
 */
public class Insert {

    Connection con;

    public Insert() throws ClassNotFoundException
    {
        Connect c = new Connect();
        con = c.getconnection();
    }

    /**************
     * Adding Creation methods for insert
     *
     * *************/

    public void CreateUserInsert( String username , int accesslvl , String password , String email , String address , Connection con)
    {
        String table = "users";
        int id = getMaxId(table);                           //THIS IS RETURNING 0

        if (id > 0)
        {
            try
            {
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
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                System.out.println("Connection failed");
                System.out.println(e.getMessage());
            }
        }
        else
            System.out.println("Error : Max Id returned 0 ");
    }

    public void CreateLogInsert( String entryLog , Connection con)
    {
        String table = "LogTable";
        int id = getMaxId(table);
        if (id > 0) {
            try
            {
                String SQL = "INSERT INTO [dbo].[LogTable]([EntryId],[LogString],[DateTime]) VALUES" +
                        "(?,?,?)";
                PreparedStatement preparedStmt = con.prepareStatement(SQL);
                preparedStmt.setInt(1, id);
                preparedStmt.setString(2, entryLog);
                preparedStmt.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
                System.out.print(SQL);
                preparedStmt.executeUpdate();
            }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Connection failed");
                System.out.println(e.getMessage());
            }
        }
    }



    public void CreateProductInsert( String type , String name , String description, float price, float weight,int quanitiy , Connection con)
    {
        String table = "items";
        int id = getMaxId(table);
        if (id > 0) {
        try
        {
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
        String column = "";
        if( table.equalsIgnoreCase("users"))
            column = "idusers";
        else if( table.equalsIgnoreCase("items"))
            column = "iditems";
        else if ( table.equalsIgnoreCase("LogTable"))
            column = "EntryId";
        SelectMax s = new SelectMax(column,table);
        ResultSet r = s.getResultset();
        int i = s.getMax(r)+ 1;
        return i;
    }
}
