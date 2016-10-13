package SQL;

import java.sql.ResultSet;

/**
 * Created by Conor on 12-Oct-16.
 */
public class Test {

    public static void main (String [] args){

        Select s = new Select("username","users","username","Customer");
        ResultSet r = s.getResultset();
        s.printSQL(r);

        s = new Select("*","items");
        r = s.getResultset();
        s.printSQL(r);

       Insert i = new Insert("items");
        i.addValue("iditems","15");
        i.addValue("type","'pen'");
        i.addValue("name","'pen'");
        i.addValue("description","'pen'");
        i.addValue("price","0.45");
        i.addValue("weight","0.2");
        i.addValue("quantity","100");

        i.executeStatement(i.constructStatement());

    }


}



