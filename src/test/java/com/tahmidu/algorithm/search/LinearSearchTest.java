package com.tahmidu.algorithm.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinearSearchTest {

    private LinearSearch linearSearch;

    @Before
    public void setUp(){
        linearSearch = new LinearSearch();
    }

    @Test
    public void search_shouldFindNumberAndReturnTrue(){

        int[] arr = {2,3,4,1};

        boolean result = linearSearch.search(4, arr);

        Assert.assertTrue(result);

    }

    @Test
    public void search_shouldNotFindNumberAndReturnFalse(){

        int[] arr = {2,3,4,1};

        boolean result = linearSearch.search(0, arr);

        Assert.assertFalse(result);

    }

}
