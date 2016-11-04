package SQL;


import java.sql.*;


/**
 * Created by Conor on 12-Oct-16.
 */
public class Select implements  SQLInterface{

    Connect con;
    Connection mycon;
    Statement mystat;
    ResultSet myRe;
    ResultSetMetaData rsmd;

    public Select(String table, String From , String Where , String Variable, Connection co) {
        // Get Connection to database when created
            mycon = co;
            String sql = "select "+ table +" from " + From + " WHERE " + Where + " = '" + Variable + "'";
            executeStatement(sql);
    }
    public Select(String table, String From ,  Connection co) {
        // Get Connection to database when created
        mycon = co;
        String sql = "select "+ table +" from " + From ;
        executeStatement(sql);
    }

    public Select(String statement, Connection co){
        mycon = co;
        executeStatement(statement);
    }

    public void executeStatement(String SQL){try {
        mystat = mycon.createStatement();
    }
    catch (Exception exc) {
        System.out.println("Select Couldn't Connect to Database!");
        System.exit(0);
    }
        try{
            myRe = mystat.executeQuery(SQL);
        }
        catch (Exception exc) {
            System.out.println(exc.fillInStackTrace());
            System.out.println("Select Statement Failed");
            System.exit(0);
        }
    }

    public void printSQL(ResultSet r){
        try {
            rsmd = r.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (r.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = r.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    public ResultSet getResultset(){return myRe;}

}
