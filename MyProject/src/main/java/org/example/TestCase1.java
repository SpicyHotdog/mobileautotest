package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {
    @Test
    public void SampleTest(){
        Assert.assertEquals(2,3);
    }
}
