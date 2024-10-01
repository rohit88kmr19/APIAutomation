package org.example.E2E;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNg001 {


    @Severity(SeverityLevel.NORMAL)
    @Description("verify that true==true")
    @Test
    public void testcase01() {
        Assert.assertEquals(true, true);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that true!=false")
    @Test
    public void testcase02()
    {
        Assert.assertEquals(true,true);
    }


}
