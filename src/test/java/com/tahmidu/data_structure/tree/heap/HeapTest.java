package com.tahmidu.data_structure.tree.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapTest {

    private Heap heap;

    @Before
    public void setUp(){
        heap = new Heap();
    }

    @Test
    public void extract_shouldReturnMaxNumAndHeapRemainsInHeapCondition() {

        int expectedMax = 53;
        int[] expectedData = {10,8,3,1,2};

        int[] data = new int[]{10,8,2,1,53,3};
        heap.setData(data);

        int resultMax = heap.extract();
        int[] resultData = heap.getHeapArray();
        Assert.assertEquals(expectedMax, resultMax);
        Assert.assertArrayEquals(expectedData, resultData);

    }

    @Test
    public void setData_shouldIterateCorrectly(){

        int[] expectedIteration = {53,10,3,1,8,2};

        int[] data = new int[]{10,8,2,1,53,3};
        heap.setData(data);

        int[] resultIteration = new int[expectedIteration.length];
        int count = 0;
        for(int i : heap){
            resultIteration[count] = i;
            count++;
        }
        Assert.assertArrayEquals(expectedIteration, resultIteration);

    }

    @Test
    public void peek_shouldReturnMaxWithoutItBeingExtracted(){

        int expectedMax = 53;

        int[] data = new int[]{10,8,2,1,53,3};
        heap.setData(data);

        int resultMax = heap.peek();
        Assert.assertEquals(expectedMax, resultMax);

    }

    @Test
    public void add_shouldRebuildHeap(){

        int[] expectedHeap = new int[]{53,10,11,1,8,2,3};

        int[] data = new int[]{10,8,2,1,53,3};
        heap.setData(data);
        heap.add(11);

        int[] resultHeap = heap.getHeapArray();
        Assert.assertArrayEquals(expectedHeap, resultHeap);

    }
}
