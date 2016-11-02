package SQL;

import java.sql.*;

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
            System.out.println("Max Select Statement Failed");
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
        return myRe;
    }
}
