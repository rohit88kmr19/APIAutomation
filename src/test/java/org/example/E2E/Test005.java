package org.example.E2E;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test005 {

@Test
public void serverStartedOK()
{
    System.out.println("I will run first");
    Assert.assertTrue(true);
}

@Test(dependsOnMethods = "serverStartedOK")
    public void method1()
{
    System.out.println("method1");
}


}
