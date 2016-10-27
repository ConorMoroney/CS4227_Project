package SQL;

import java.sql.*;

/**
 * Created by Conor on 12-Oct-16.
 */
public class Update {

    Connection con;

    public Update() throws ClassNotFoundException {
        Connect c = new Connect();
        con = c.getconnection();
    }


    public void UpdateItems(int newAmount , int itemId ) {
        try {


            String SQL = "UPDATE [dbo].[items] SET [quantity] = ? WHERE iditems = ?";

            PreparedStatement preparedStmt = con.prepareStatement(SQL);
            preparedStmt.setInt(1, newAmount);
            preparedStmt.setInt(2, itemId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


