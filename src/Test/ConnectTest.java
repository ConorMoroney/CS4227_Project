package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by shane on 11-Oct-16.
 */
public class ConnectTest {
    //public Java.Connect conTest;
    public Boolean name = true;
    @Before
    public void setUp() throws Exception {
      //  Java.Connect conTest = new Java.Connect();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test(){
        assertTrue(name);
    }



}

