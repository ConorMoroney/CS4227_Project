package SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Conor on 12-Oct-16.
 */
public class Insert {


    Connect con;
    Connection mycon;
    Statement mystat;
    ResultSet myRe;
    String SQL;
    ArrayList <String> Values = new ArrayList<String>() ;
    ArrayList <String> Types = new ArrayList<String>();
    String first;
    String second;


    public Insert(String table){

        SQL = "insert into " + table + " (";

    }

    public void addValue(String value , String type){


        System.out.println(first);
        System.out.println(second);


            Values.add(value);
            Types.add(type);

        int i = 0;
        for(String s : Values){
            if(i < 1 ){
                first = s;
                second = Types.get(i);
            }
            else {
                first = first + " ," + s;
                second = second + " ," + Types.get(i);
            }
            i++;
        }

        System.out.println(first);
        System.out.println(second);

        constructStatement();
    }

    public String constructStatement(){


        String Result = SQL +  first + ") Values (" + second + ")";
        System.out.println(Result);
        return Result;
    }

    public void executeStatement(String SQL){




        try {
        con = new Connect();
        mycon =  con.getconnection();
        mystat = mycon.createStatement();
    }
    catch (Exception exc) {
        System.out.println("Insert Couldn't Connect to Database!");
        System.exit(0);
    }
        try{
            myRe = mystat.executeQuery(SQL);
        }
        catch (Exception exc) {
            System.out.println("Insert Statement Failed");
            System.exit(0);
        }
    }
}
