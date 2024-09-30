package org.example.TestNg;

import org.testng.annotations.*;

public class Test003 {

    @BeforeSuite
    void demo1()
    {
        System.out.println("Read the data from the Excel/MySql");
    }

    @BeforeTest
    void demo2(){
        System.out.println("Data in Matrix, TC before");
    }

    @BeforeClass
    void demo3(){
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    void demo4(){
        System.out.println("BeforeMethod");
    }

    @Test
    void demo5(){
        System.out.println("Test");
    }

    @AfterMethod
    void demo6(){
        System.out.println("AfterMethod");
    }

    @AfterClass
    void demo7(){
        System.out.println("AfterClass");
    }

    @AfterTest
    void demo8(){
        System.out.println("AfterTest");
    }
    @AfterSuite
    void demo9() {
        System.out.println("AfterSuite");
        System.out.println("Close everything, Delete all the temp files");

    }

}
