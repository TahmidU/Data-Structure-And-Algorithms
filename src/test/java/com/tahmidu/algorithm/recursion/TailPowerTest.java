package com.tahmidu.algorithm.recursion;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TailPowerTest {

    TailPower tailPower;

    @Before
    public void setUp(){
        tailPower = new TailPower();
    }

    @Test
    public void tailPower_shouldReturnCorrectAnswer(){

        int expected = 5 * 5 * 5;

        int result = tailPower.tailPower(5, 3);

        Assert.assertEquals(expected, result);

    }

}
