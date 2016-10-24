package SQL;


import java.sql.*;


/**
 * Created by Conor on 12-Oct-16.
 */
public class Select {

    ///Connect con;
    //Connection mycon;
    Statement mystat;
    ResultSet myRe;

    public Select(String result, String From , String Where , String Variable, Connection mycon) {
        // Get Connection to database when created
            String sql = "select "+ result +" from " + From + " WHERE " + Where + " = '" + Variable + "'";
            executeStatement(sql, mycon);
    }
    public Select(String result, String From, Connection mycon) {
        // Get Connection to database when created
        String sql = "select "+ result +" from " + From ;
        executeStatement(sql, mycon);
    }

    public void executeStatement(String SQL, Connection mycon){try {
        //con = new Connect();
        //mycon =  con.getconnection();
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
        	System.out.println(exc.toString());
            System.out.println("Select Statement Failed");
            System.exit(0);
        }
    }

    public static void printSQL(ResultSet r){
        try {
            ResultSetMetaData rsmd = r.getMetaData();
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
