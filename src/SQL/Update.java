package SQL;

import java.sql.*;

/**
 * Created by Conor on 12-Oct-16.
 */
public class Update {

    private Connection con;

    public Update(Connection mycon) {
        con = mycon;
    }


    public boolean UpdateItems(int newAmount , String name ) {
        try {


            String SQL = "UPDATE [dbo].[items] SET [quantity] = ? WHERE name = ?";

            PreparedStatement preparedStmt = con.prepareStatement(SQL);
            preparedStmt.setInt(1, newAmount);
            preparedStmt.setString(2, name);
            System.out.println(SQL);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}


