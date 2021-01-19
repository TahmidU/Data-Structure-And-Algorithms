package com.tahmidu.algorithm.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

    private BinarySearch binarySearch;

    @Before
    public void setUp(){
        binarySearch = new BinarySearch();
    }

    @Test
    public void search_shouldFindNumberInSortedArrAndReturnTrue(){

        int[] arr = {1,2,3,4,5,6,7,8,9};

        boolean result = binarySearch.search(6, arr);

        Assert.assertTrue(result);

    }

    @Test
    public void search_shouldNotFindNumberInSortedArrAndReturnFalse(){

        int[] arr = {1,2,3,4,5,6,7,8,9};

        boolean result = binarySearch.search(0, arr);

        Assert.assertFalse(result);

    }

    @Test
    public void search_shouldNotFindNumberInUnsortedArrAndReturnFalse(){

        int[] arr = {1,2,3,9,8,7,4,5,6};

        boolean result = binarySearch.search(5, arr);

        Assert.assertFalse(result);

    }


}
