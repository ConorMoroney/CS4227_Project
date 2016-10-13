package SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Conor on 12-Oct-16.
 */
public class Update {

    Connect con;
    Connection mycon;
    Statement mystat;
    ResultSet myRe;


    public Update(String table, String Set , String newAmount ,String Where , String Variable)
    {

      /*  String sql = "UPDATE [dbo].["+table+"]\n" +
                "   SET ["+Set+"] = "+newAmount+"\n" +
                " WHERE "+Where+" = "+ Variable ;*/

      String sql = "update items set quantity = 390 where iditems = 1";
        executeStatement(sql);
    }


    public void executeStatement(String SQL){try {
        con = new Connect();
        mycon =  con.getconnection();
        mystat = mycon.createStatement();
    }
    catch (Exception exc) {
        System.out.println("Update Couldn't Connect to Database!");
        System.exit(0);
    }
        try{
          mystat.execute(SQL);
            System.out.print("Updated\n");
        }
        catch (Exception exc) {
            System.out.println("Update Statement Failed");
            System.exit(0);
        }
    }
}


