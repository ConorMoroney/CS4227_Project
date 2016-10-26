package SQL;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Conor on 12-Oct-16.
 */
public class Insert {


    String SQL;
    ArrayList <String> Values = new ArrayList<String>() ;
    ArrayList <String> columntypes = new ArrayList<String>();
    String tablenames;
    ResultSetMetaData rsmd;

    public Insert(String table){

        Select s = new Select("*",table);
        ResultSet r = s.getResultset();

        try {
            rsmd = r.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
           // while (r.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) tablenames += ",";
                    if (i == 1 )  tablenames = rsmd.getColumnName(i);
                    else tablenames += rsmd.getColumnName(i);
                    columntypes.add(rsmd.getColumnTypeName(i));
                }

            //}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQL = "INSERT into " + table + " (" + tablenames + ") VALUES(";

        System.out.println(SQL);


    }

    public void addValue(ArrayList <String> values){
            Values = values;
        for (int i =0;i< Values.size();i++){
            if (i >= 1) SQL += ",";

            SQL += "'" + Values.get(i) + "'";
        }
        SQL += ");";
        System.out.println(SQL);

        executeStatement(SQL);

    }


    public void executeStatement(String SQL){
        Statement mystat;
        try {
            Connect con = new Connect();
            Connection mycon =  con.getconnection();
            mystat = mycon.createStatement();
            mystat.executeUpdate(SQL);
            mystat.close();
            mycon.close();
    }
    catch (Exception exc) {
        System.out.println("Insert Couldn't Connect to Database!");
        System.exit(0);
    }

    }
}
