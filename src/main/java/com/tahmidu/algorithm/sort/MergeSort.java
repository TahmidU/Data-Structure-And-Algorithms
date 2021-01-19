package com.tahmidu.algorithm.sort;

public class MergeSort
{
    private int[] data;

    public MergeSort(int[] data)
    {
        this.data = data;
    }

    public MergeSort() {
    }

    public int[] sort()
    {
        return mergeSort(data);
    }

    public int[] mergeSort(int[] arr){

        if(arr.length < 2)
            return arr;

        int length = arr.length;
        int midPoint = length/2;

        int[] left = new int[midPoint];
        int[] right = new int[length - midPoint];

        System.arraycopy(arr, 0, left, 0, midPoint);
        System.arraycopy(arr, midPoint, right, 0, length-midPoint);

        int[] arrayOne = mergeSort(left);
        int[] arrayTwo = mergeSort(right);

        return merge(arrayOne, arrayTwo);
    }

    private int[] merge(int[] arr, int[] arr2){

        int[] result = new int[arr.length+arr2.length];
        int resultPos = 0, arrPos = 0, arr2Pos = 0;

        // Compare both arrays and place their elements in the correct position.
        while (arr.length > arrPos && arr2.length > arr2Pos){

            if(arr[arrPos] < arr2[arr2Pos])
                result[resultPos++] = arr[arrPos++];
            else
                result[resultPos++] = arr2[arr2Pos++];

        }

        // Once one of the arrays has been exhausted place the other arrays remaining elements in the result.
        while (arr.length > arrPos)
            result[resultPos++] = arr[arrPos++];

        while (arr2.length > arr2Pos)
            result[resultPos++] = arr2[arr2Pos++];


        return result;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}
