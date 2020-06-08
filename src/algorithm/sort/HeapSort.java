package algorithm.sort;

import data_structure.tree.heap.Heap;

import java.util.Arrays;

/**
 * Heap sort algorithm using max heap.
 */
public class HeapSort
{
    private Heap heap;

    public HeapSort(int data[])
    {
        heap = new Heap(data);
    }

    public int[] sort()
    {
        //First turn the array into a heap. Heapify each sub-tree first.
        for(int i = heap.size()/2 - 1; i>=0; i--)
        {
            heap.heapifyDown(i);
        }

        for(int i = heap.size(); i>0; i--)
        {
            heap.maxToEnd();
            heap.heapifyDown(0);
        }
        return heap.getData();
    }

    public static void main(String[] args)
    {
        int[] arr = {0,1,3,2,20,11,23,22};

        HeapSort heapSort = new HeapSort(arr);
        Arrays.stream(heapSort.sort()).forEach(System.out::println);
    }

}
