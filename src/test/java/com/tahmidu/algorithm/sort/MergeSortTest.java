package com.tahmidu.algorithm.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    private MergeSort mergeSort;

    @Before
    public void setUp(){
        mergeSort = new MergeSort();
    }

    @Test
    public void sort_shouldReturnArrSorted(){

        int[] expectedData = new int[]{0,8,15,40,200};

        int[] data = new int[]{200,0,40,15,8};
        mergeSort.setData(data);

        int[] resultData = mergeSort.sort();
        Assert.assertArrayEquals(expectedData, resultData);

    }

}
