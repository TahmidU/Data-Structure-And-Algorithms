package com.tahmidu.algorithm.search;

/**
 * Binary Search Algorithm. Only works with sorted arrays.
 */
public class BinarySearch
{
    public boolean search(int elt, int[] arr)
    {
        if(arr.length == 1)
            return arr[0] == elt;

        if(arr.length == 0)
            return false;

        int pos = arr.length/2-1;

        if(arr[pos] == elt)
            return true;

        int[] newArr;
        if(arr[pos] > elt)
        {
            newArr = new int[pos];
            System.arraycopy(arr, 0, newArr, 0, pos);
        }else
            {
                newArr = new int[arr.length - pos - 1];
                System.arraycopy(arr, pos+1, newArr, 0, arr.length-pos-1);
            }
        return search(elt, newArr);
    }
}
