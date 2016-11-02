package SQL;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.sql.*;
import java.sql.Connection;


/**
 * Created by Conor on 12-Oct-16.
 */
public class Test {

    public static void main (String [] args) throws ClassNotFoundException {



        //i.CreateUserInsert("mike",2,"pass","email","address",i.getConnection());
        //i.CreateProductInsert(6,"pen","pencil","pencil",1,1,20,i.getConnection());
        Insert i =new Insert();
        i.CreateLogInsert("Test Log Entry", i.getConnection());

        Select s = new Select("*","LogTable");
        ResultSet r = s.getResultset();
        s.printSQL(r);

        SelectMax m = new SelectMax("idusers", "users");
        r = m.getResultset();
        s.printSQL(r);


        // Update u = new Update();
       // u.UpdateItems(50,15);
    }



}



