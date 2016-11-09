package SQL;

import java.sql.*;


/**
 * Created by Conor on 12-Oct-16.
 */
class Test {

    public static void main (String [] args) throws ClassNotFoundException {


/*
        //i.CreateUserInsert("mike",2,"pass","email","address",i.getConnection());
        //i.CreateProductInsert(6,"pen","pencil","pencil",1,1,20,i.getConnection());
        Insert i =new Insert();
        i.CreateLogInsert("Test Log Entry", i.getConnection());

        Select s = new Select("*","LogTable",i.getConnection());
        ResultSet r = s.getResultset();
        s.printSQL(r);

        SelectMax m = new SelectMax("idusers", "users", i.getConnection());
        r = m.getResultset();
        s.printSQL(r);*/


        // Update u = new Update();
       // u.UpdateItems(50,15);
            Connect c = new Connect();
            Connection con = c.getconnection();
            String itemName = "bic";
            int orderQuantity = 15;
            Update u = new Update();
            //u.UpdateTest(orderQuantity,itemName,con);

        }


    }






