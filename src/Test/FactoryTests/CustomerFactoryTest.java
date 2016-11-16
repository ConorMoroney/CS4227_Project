package Test.FactoryTests;

import User.ConcreteCustomer;
import User.CustomerFactory;
import User.I_Customer;
import org.junit.*;
import org.junit.rules.TestName;

/**
 * Created by shane on 04-Nov-16.
 */
public class CustomerFactoryTest {
    private CustomerFactory cf = new CustomerFactory();
    String [] customerTypes = {"Customer"};
    private String testMessage = "";
    @Rule public TestName name = new TestName();

    @BeforeClass
    public static void runOnceBeforeClass(){
        System.out.println("Test Class: CustomerFactoryTest.java\n");
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
    public void testUserCreatedWithUserType() throws Exception {
        for (String s:customerTypes){
            testMessage = "TEST CASE NAME:" + name.getMethodName() +  "\n A valid customer is created when passed a valid customer type from the list";
            I_Customer testI = cf.createUser(s);
            Assert.assertTrue( testI instanceof I_Customer);


        }
    }

    @Test
    public void testUserNotCreatedWithWrongValue() throws Exception {
        testMessage = "TEST CASE NAME:" + name.getMethodName() +  "\n A valid customer is not created when passed an invalid customer type";
            I_Customer testI = cf.createUser("INVALID");
            Assert.assertFalse( testI instanceof I_Customer);
    }
    @AfterClass
    public static void runOnceAfterClass(){
        System.out.println("Execution Complete: CustomerFactoryTest.java\n");
    }

}