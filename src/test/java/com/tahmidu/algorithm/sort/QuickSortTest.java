package com.tahmidu.algorithm.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {

    private QuickSort quickSort;

    @Before
    public void setUp(){
        quickSort = new QuickSort();
    }

    @Test
    public void sort_shouldReturnArrSorted(){

        int[] expectedData = new int[]{1,3,4,5,6,10,11,13,20};

        int[] data = new int[]{4,1,3,6,5,13,10,20,11};
        quickSort.setData(data);

        int[] resultData = quickSort.sort();
        System.out.println(Arrays.toString(resultData));
        Assert.assertArrayEquals(expectedData, resultData);

    }

}
