package SQL;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.sql.*;
import java.sql.Connection;


/**
 * Created by Conor on 12-Oct-16.
 */
public class Test {

    public static void main (String [] args) throws ClassNotFoundException {




        /*Insert i =new Insert();
        i.CreateUserInsert(57,"mike",2,"pass","email","address",i.getConnection());

        i.CreateProductInsert(6,"pen","pencil","pencil",1,1,20,i.getConnection());
*/



        Update u = new Update();
        u.UpdateItems(50,15);
    }



}



