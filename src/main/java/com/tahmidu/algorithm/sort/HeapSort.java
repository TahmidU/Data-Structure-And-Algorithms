package com.tahmidu.algorithm.sort;

import com.tahmidu.data_structure.tree.heap.Heap;
import java.util.Arrays;

/**
 * Heap sort main.java.com.tahmidu.algorithm using max heap.
 */
public class HeapSort
{
    private Heap heap;

    public HeapSort(int[] data)
    {
        heap = new Heap(data);
    }

    public HeapSort() {
    }

    public int[] sort()
    {
        for(int i = heap.size(); i>0; i--)
            heap.extract();

        return heap.getData();
    }

    public void setHeap(int[] data) {
        this.heap = new Heap(data);
    }

    public Heap getHeap() {
        return heap;
    }

}
