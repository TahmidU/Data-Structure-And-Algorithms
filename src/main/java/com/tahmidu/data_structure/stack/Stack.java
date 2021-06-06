package com.tahmidu.data_structure.stack;

import java.util.Iterator;

/**
 * Linear Data Structure forming a LIFO queue.
 */
@SuppressWarnings("CommentedOutCode")
public class Stack implements Iterable<Integer>
{

    private int count = 0;
    private int[] data;

    public Stack() {
        this.data = new int[1];
    }

    public Stack(int count) {
        this.data = new int[count];
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public boolean isFull()
    {
        return data[data.length-1] != 0;
    }

    public int pop()
    {
        int popped = data[--count];
        data[count] = 0;
        return popped;
    }

    //Dynamically reduces the array size.
    //Advantage: Takes less space in memory.
    public int reallocatePop()
    {
        int popped = data[--count];
        int[] d1 = new int[data.length - 1]; //Create new array with -1 space than prev array.

        //Copy elements to new array.
        System.arraycopy(data, 0, d1, 0, count);
        data = d1;
        return popped;
    }

    //Amortised Cost: O(1)
    public void push(int elt)
    {
        if(count == data.length)
        {
            int currentLength = data.length * 2;//Double the length
            int[] d1 = new int[currentLength];

            System.arraycopy(data, 0, d1, 0, count);
            data = d1;
        }

        data[count++] = elt;
    }

    public int stackLength()
    {
        return data.length;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int currIndex = 0;

            @Override
            public boolean hasNext() {
                return currIndex < data.length - 1 && data[currIndex] != 0;
            }

            @Override
            public Integer next() {
                return data[currIndex++];
            }
        };
    }
}

