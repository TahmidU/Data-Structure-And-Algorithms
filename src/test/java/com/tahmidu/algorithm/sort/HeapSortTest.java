package com.tahmidu.algorithm.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapSortTest {

    private HeapSort heapSort;

    @Before
    public void setUp(){
        heapSort = new HeapSort();
    }

    @Test
    public void sort_shouldReturnArrSorted() {

        int[] expectedData = new int[]{0,1,2,3,11,20,22,23};

        int[] data = {0,1,3,2,20,11,23,22};
        heapSort.setHeap(data);

        int[] resultData = heapSort.sort();
        Assert.assertArrayEquals(expectedData, resultData);
    }

    @Test
    public void getHeap_shouldReturnArrAsHeapArray(){

        int[] expectedData = new int[]{53,10,3,1,8,2};

        int[] data = new int[]{10,8,3,1,53,2};
        heapSort.setHeap(data);

        int[] resultData = heapSort.getHeap().getData();
        Assert.assertArrayEquals(expectedData, resultData);
    }
}
