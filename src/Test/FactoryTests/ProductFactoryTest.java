package Test.FactoryTests;

import Java.I_Product;
import Java.ProductFactory;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by shane on 11-Oct-16.
 */
public class ProductFactoryTest {

    private final ProductFactory prodF = new ProductFactory();
    private final String [] productTypes = {"pen","pencil","paper","envelope","paperclip","folder", "ruler", "copy"};


    @Before
    public void setUp() throws Exception {

        System.out.println("Begin Test");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("End Test: ");

    }

    @Test
    public void testValidProductCreated() throws Exception {
        for (String s:productTypes){
            I_Product testI = prodF.createProduct(s);
            Assert.assertTrue( testI instanceof I_Product);
        }

    }

    @Test
    public void testInvalidProductNotCreated() throws Exception {
        I_Product testI = prodF.createProduct("FAIL");
        Assert.assertFalse( testI instanceof I_Product);

    }
}