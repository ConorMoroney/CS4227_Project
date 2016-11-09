package SQL;

import java.sql.*;

/**
 * Created by Conor on 12-Oct-16.
 */
public class Insert {

    private Connection con;

    public Insert()
    {
    }

    /**************
     * Adding Creation methods for insert
     *
     * *************/

    public int CreateUserInsert( String username , int accesslvl , String password , String email , String address , Connection con)
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
                return id; // return id of new user if successful


            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Connection failed");
                System.out.println(e.fillInStackTrace());
            }
        }
        return -1; //return -1 if unsuccessful
    }

    public boolean CreateOrderInsert(String name,  int quantity, String customer, Connection con){
        String table = "orderqueue";
        try
            {
                String SQL = "INSERT INTO [dbo].[orderqueue]([name],[quantity],[customer]) VALUES" +
                        "(?,?,?)";
                PreparedStatement preparedStmt = con.prepareStatement(SQL);
                preparedStmt.setString(1, name);
                preparedStmt.setInt(2, quantity);
                preparedStmt.setString(3, customer);
                System.out.print(SQL);
                preparedStmt.executeUpdate();
                return true;
            }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Connection failed");
                System.out.println(e.getMessage());
            }
        return false;
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
        return -1; //return -1 if unsuccessful
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
        SelectMax s = new SelectMax(column,table, con);
        ResultSet r = s.getResultset();
        return s.getMax(r)+ 1;
    }
}
