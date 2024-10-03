package org.example.Verification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01TestNgVer {

    @Test
    public void test_verify() {
        String responseName = "pramod";
        Assert.assertEquals("pramod", responseName);


    }
}