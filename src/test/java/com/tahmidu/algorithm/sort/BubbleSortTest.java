package com.tahmidu.algorithm.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

    private BubbleSort bubbleSort;

    @Before
    public void setUp(){
        bubbleSort = new BubbleSort();
    }

    @Test
    public void sort_shouldReturnSortedArr(){

        int[] expectedData = new int[]{0,8,15,40,200};

        int[] data = new int[]{200,0,40,15,8};
        bubbleSort.setData(data);
        int[] resultData = bubbleSort.sort();

        Assert.assertArrayEquals(expectedData, resultData);

    }
}
