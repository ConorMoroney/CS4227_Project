package SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Conor on 28-Oct-16.
 */
class SelectMax implements SQLInterface {
    private ResultSet myRe;


    public SelectMax(String column ,String table){

        String SQL = "select Max("+column+") from "+table;

        executeStatement(SQL);
    }

    @Override
    public void executeStatement(String SQL) {
        try{
            Connect con = new Connect();
            Connection mycon =  con.getconnection();
            Statement mystat = mycon.createStatement();
            myRe = mystat.executeQuery(SQL);
        }
        catch (Exception exc) {
            System.out.println("Select Statement Failed");
            System.exit(0);
        }
    }

   
    public ResultSet getResultset() {
        return myRe;    }
}
