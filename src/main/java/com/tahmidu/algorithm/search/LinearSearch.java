package com.tahmidu.algorithm.search;

/**
 * Linear Search Algorithm. Can search through both sorted and unsorted arrays.
 */
public class LinearSearch
{
    public boolean search(int elt, int[] arr)
    {
        for(int i : arr)
            if(i == elt)
                return true;

        return false;
    }
}
