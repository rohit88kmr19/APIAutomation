package org.example.E2E;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test006 {

    @Parameters("browser")
    @Test
    void demo1(String value)
    {

        System.out.println("browser is chrome");

    }




}
