package testPackage;

import org.testng.annotations.*;

public class WorkflowTests {

    @Test
    public void testMethod1(){
        System.out.println("Test Method 1");
    }

    @Test
    public void testMethod2(){
        System.out.println("Test Method 2");
    }

    @Test
    public void testMethod3(){
        System.out.println("Test Method 3");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
}
