package SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Conor on 28-Oct-16.
 */
public class SelectMax implements SQLInterface {
    private ResultSet myRe;
    private Connection mycon;


    public SelectMax(String column ,String table, Connection mycon){

        String SQL = "select Max("+column+") from "+table;
        this.mycon = mycon;

        executeStatement(SQL);
    }

    @Override
    public void executeStatement(String SQL) {
        try{
            System.out.println("a");
            Statement mystat = mycon.createStatement();
            System.out.println("b");
            myRe = mystat.executeQuery(SQL);
            System.out.println("c");
        }
        catch (Exception exc) {
            System.out.println(exc.fillInStackTrace());
            System.exit(0);
        }
    }

   
    public ResultSet getResultset() {
        return myRe;    }
}
