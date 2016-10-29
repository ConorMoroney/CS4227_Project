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

    public Select(String table, String From , String Where , String Variable) {
        // Get Connection to database when created
            String sql = "select "+ table +" from " + From + " WHERE " + Where + " = '" + Variable + "'";
            executeStatement(sql);
    }
    public Select(String table, String From ) {
        // Get Connection to database when created
        String sql = "select "+ table +" from " + From ;
        executeStatement(sql);
    }

    public void executeStatement(String SQL){try {
        con = new Connect();
        mycon =  con.getconnection();
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
