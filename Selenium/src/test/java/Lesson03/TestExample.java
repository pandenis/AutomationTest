package Lesson03;

import org.testng.annotations.*;

public class TestExample {
    @BeforeTest

    public void beforeTest() {
        System.out.println("BeforeTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass");
    }


    @BeforeMethod

    public void beforeMethod() {
        System.out.println("Before each Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After each Method");
    }


    @Test(priority = 1, enabled = false)
    public static void test00 () {
        System.out.println("Test00");

    }

    @Test(priority = 2)
    public static void test01() {
        System.out.println("Test01");

    }

    @Test(priority = 4)
    public static void test02() {
        System.out.println("Test02");

    }

    @Test(priority = 3)
    public static void test03() {
        System.out.println("Test03");

    }
}
