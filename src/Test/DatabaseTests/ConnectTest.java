package Test.DatabaseTests;

import SQL.Connect;
import org.junit.*;
import org.junit.Test;
import org.junit.rules.TestName;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

/**
 * Created by shane on 11-Oct-16.
 */
public class ConnectTest {
    @Rule
    public TestName name = new TestName();
    private Connection mycon;
    private Connect con;
    private Statement mystat;
    private String testMessage = "";


    @BeforeClass
    public static void runOnceBeforeClass(){
        System.out.println("Test Class: ConnectTest.java\n");
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
    public void connectionTest() throws SQLException {

        con = new Connect();
        testMessage = "TEST CASE NAME: " + name.getMethodName() + "\n Connection to the database has been established";

    }
    @AfterClass
    public static void runOnceAfterClass(){
        System.out.println("Connection Closed + Execution Complete: ConnectTest.java\n");
    }

}
