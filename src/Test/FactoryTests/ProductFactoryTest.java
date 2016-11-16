package Test.FactoryTests;

import GUI.MainWindow;
import Java.I_Product;
import Java.ProductFactory;
import junit.framework.Assert;
import org.junit.*;
import org.junit.rules.TestName;

/**
 * Created by shane on 11-Oct-16.
 */
public class ProductFactoryTest {
    @Rule
    public TestName name = new TestName();
    private final ProductFactory prodF = new ProductFactory();
    private final String [] productTypes = prodF.getConcreteTypes();
    private String testMessage = "";
    private String [] newProd ={"spark plugs","lug nuts","battery","hub caps","tires","rims", "bulb", "`stereo"};

    @BeforeClass
    public static void runOnceBeforeClass(){
        System.out.println("Test Class: ProductFactoryTest.java\n");
    }

    @Before
    public void setUp() throws Exception {

        System.out.println("Begin Test");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println(testMessage);
        System.out.println("End Test \n");

    }

    @Test
    public void testValidProductCreated() throws Exception {
        for (String s:productTypes){
            I_Product testI = prodF.createProduct(s);
            Assert.assertTrue( testI instanceof I_Product);
            testMessage = "TEST CASE NAME: "+name.getMethodName()+"\n A valid product is created when passed a valid product type from the list";
        }

    }

    @Test
    public void testInvalidProductNotCreated() throws Exception {
        I_Product testI = prodF.createProduct("FAIL");
        Assert.assertFalse( testI instanceof I_Product);
        testMessage = "TEST CASE NAME: "+name.getMethodName()+"\n A valid product is not created when passed an invalid product type from the list";
    }


    @Test
    public void testNewEmployeeTypes()throws Exception{
        testMessage = "TEST CASE NAME: " + name.getMethodName() +  "\n\n Testing that new product types can be created which replace the old types";
        prodF.setConcreteTypes(newProd);
        //System.out.println("New Employee Types to be created:  ");
        testMessage+="\nNew Product Types created:  ";
        for (int i=0;i<newProd.length;i++){
            testMessage+=(newProd[i] + ", \t");
        }
        for (String s:newProd) {
            I_Product testI = prodF.createProduct(s);
            org.junit.Assert.assertTrue(testI instanceof I_Product);
        }
        testMessage +="\n\nA valid product is created when passed a valid product type from the new  list";

        for (String s:productTypes){
            I_Product testI = prodF.createProduct(s);
            org.junit.Assert.assertFalse( testI instanceof I_Product);
        }
        testMessage +="\n\nA product cannot now be created form the old list once the new employee types are implemented";

    }
    @AfterClass
    public static void runOnceAfterClass(){
        System.out.println("Execution Complete: CustomerFactoryTest.java\n");
    }
}