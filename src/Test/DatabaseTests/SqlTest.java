package Test;

import SQL.Connect;
import org.junit.*;
import org.junit.Test;
import org.junit.rules.TestName;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by shane on 13-Nov-16.
 */
public class SqlTest {
    @Rule
    public TestName name = new TestName();
    private Connection mycon;
    private Connect con;
    private Statement mystat;
    private String testMessage = "";


    @BeforeClass
    public static void runOnceBeforeClass(){
        System.out.println("Test Class: SqlTest.java\n");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Begin Test ");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println(testMessage + "\n");
        System.out.println("End Test\n");
    }

    @Test
    public void connectTest() throws SQLException {
        testMessage = "TEST CASE NAME: " + name.getMethodName() + "\n Connection to the database has been established";
        con = new Connect();
    }


    @Test
    public void testStatementsOnDB()throws SQLException {
        con = new Connect();
        testMessage = "TEST CASE NAME: " + name.getMethodName() + "\n SQL interaction successful";
        mycon = con.getconnection();

        mystat = mycon.createStatement();

        String sql = "select * from items";
        ResultSet myRe = mystat.executeQuery(sql);
        testMessage+= "\n Statements correctly working in database";

    }

    @AfterClass
    public static void runOnceAfterClass(){
        System.out.println("Connection Closed + Execution Complete: ConnectTest.java\n");
    }

}

