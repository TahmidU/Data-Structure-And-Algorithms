package com.tahmidu.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    private int[] data;

    public QuickSort() {
    }

    public QuickSort(int[] data) {
        this.data = data;
    }

    public int[] sort(){
        System.out.println(Arrays.toString(data));
        quicksort(0, data.length-1);
        return data;
    }

    private void quicksort(int left, int right){
        if(left >= right)
            return;

        int partitionIndex = partition(left, right);
        quicksort(left, partitionIndex-1);
        quicksort(partitionIndex+1, right);
    }

    private int partition(int left, int right){
        int pivotElm = data[(left+right)/2];

        while(left != right){

            while(data[left] < pivotElm) left++;
            while(data[right] > pivotElm) right--;

            swap(left, right);
        }

        // You can return right or left, doesn't matter (they're identical).
        return right;
    }

    private void swap(int left, int right)
    {
        int temp = data[right];
        data[right] = data[left];
        data[left] = temp;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}
