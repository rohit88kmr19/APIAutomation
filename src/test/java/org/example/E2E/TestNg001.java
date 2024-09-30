package org.example.E2E;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNg001 {


    @Test
    public void testcase01() {
        Assert.assertEquals(true, true);
    }

    @Test
    public void testcase02()
    {
        Assert.assertEquals(true,false);
    }


}
