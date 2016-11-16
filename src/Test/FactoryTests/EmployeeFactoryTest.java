package Test.FactoryTests;

import User.EmployeeFactory;
import User.I_Employee;
import org.junit.*;
import org.junit.rules.TestName;

/**
 * Created by shane on 04-Nov-16.
 */
public class EmployeeFactoryTest {
    @Rule
    public TestName name = new TestName();
    private EmployeeFactory ef = new EmployeeFactory();
    private String [] employeeTypes = ef.getConcreteUserTypes();

    private String newTypes [] = {"Checkout Clerk","Crew Trainer","Supervisor"};
    private String testMessage = "";

    @BeforeClass
    public static void runOnceBeforeClass(){
        System.out.println("Test Class: EmployeeFactoryTest.java\n");
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
    public void testEmployeeCreatedWithEmployeeType() throws Exception {
        for (String s:employeeTypes){
            I_Employee testI = ef.createUser(s);
            Assert.assertTrue( testI instanceof I_Employee);
            testMessage = "TEST CASE NAME: " + name.getMethodName() + "\n A valid employee is created when passed a valid employee type from the list";
        }
    }

    @Test
    public void testEmployeeNotCreatedWithWrongValue() throws Exception {
        testMessage = "TEST CASE NAME: " + name.getMethodName() +  "\n A valid customer is not created when passed an invalid customer type";
        I_Employee testI = ef.createUser("INVALID");
        Assert.assertFalse( testI instanceof I_Employee);
    }

    @Test
    public void testNewEmployeeTypes()throws Exception{
        testMessage = "TEST CASE NAME: " + name.getMethodName() +  "\n\n Testing that new employee types can be created which replace the old types";
        ef.setConcreteUserTypes(newTypes);
        //System.out.println("New Employee Types to be created:  ");
        testMessage+="\nNew Product Types created:  ";
        for (int i=0;i<newTypes.length;i++){
            testMessage+=(newTypes[i] + ", \t");
        }
        for (String s:newTypes) {
            I_Employee testI = ef.createUser(s);
            Assert.assertTrue(testI instanceof I_Employee);
        }
        testMessage +="\n\nA valid product is created when passed a valid product type from the new  list";

        for (String s:employeeTypes){
            I_Employee testI = ef.createUser(s);
            Assert.assertFalse( testI instanceof I_Employee);
        }
        testMessage +="\n\nA product cannot now be created form the old list once the new product types are implemented";

    }

    @AfterClass
    public static void runOnceAfterClass(){
        System.out.println("Execution Complete: EmployeeFactoryTest.java\n");
    }
    
}






