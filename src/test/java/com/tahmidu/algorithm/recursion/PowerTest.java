package com.tahmidu.algorithm.recursion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PowerTest {

    public Power power;

    @Before
    public void setUp(){
        power = new Power();
    }

    @Test
    public void power_shouldReturnCorrectAnswer(){

        int expected = 5 * 5 * 5;

        int result = power.power(5,3,0);

        Assert.assertEquals(expected, result);

    }

    @Test
    public void power_shouldReturnOne(){

        power = new Power();

        int result = power.power(0, 0, 0);

        Assert.assertEquals(1, result);

    }

}
