package Test;

import Test.DatabaseTests.ConnectTest;
import Test.DatabaseTests.SqlTest;
import Test.FactoryTests.CustomerFactoryTest;
import Test.FactoryTests.EmployeeFactoryTest;
import Test.FactoryTests.ProductFactoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by shane on 13-Nov-16.
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
        CustomerFactoryTest.class,
        EmployeeFactoryTest.class,
        ProductFactoryTest.class,
        ConnectTest.class,
        SqlTest.class
})
public class TestSuite {
}
