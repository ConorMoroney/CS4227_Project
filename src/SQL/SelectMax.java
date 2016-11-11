package SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Created by Conor on 28-Oct-16.
 */
public class SelectMax implements SQLInterface {
    private ResultSet myRe;
    private final Connection mycon;

    public SelectMax(String column ,String table, Connection mycon){

        String SQL = "select Max("+column+") from "+table;
        this.mycon = mycon;

        executeStatement(SQL);
    }

    @Override
    public void executeStatement(String SQL) {
        try{
            Statement mystat = mycon.createStatement();
            myRe = mystat.executeQuery(SQL);
        }
        catch (Exception exc) {
            System.out.println(exc.fillInStackTrace());
            System.exit(0);
        }
    }

    public int getMax(ResultSet r) {
        int max = 0;
        try {
            while (r.next()) {
                    max = Integer.parseInt(r.getString(1));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return max;
    }

    public ResultSet getResultset() {
        return myRe;    }
}
