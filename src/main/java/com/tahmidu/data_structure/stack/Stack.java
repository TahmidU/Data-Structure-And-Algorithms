package com.tahmidu.data_structure.stack;

import java.util.Iterator;

/**
 * Linear Data Structure forming a LIFO queue.
 */
public class Stack implements Iterable<Integer>
{

    private int count = 0;
    private int[] data = new int[1];

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

    //Amortised Cost O(n)
    public void push(int elt)
    {
        //If there's no space in the main.java.com.tahmidu.data_structure.stack...
        if(count == data.length)
        {
            int[] d1 = new int[data.length + 1]; //Create a new array with +1 space than prev array.

            //Copy elements from the prev array to the new array.
            System.arraycopy(data, 0, d1, 0, count);
            data = d1;
        }
        //Place new values at the last position of array.
        data[count++] = elt;
    }

    //Amortised Cost: O(1)
    public void optimisedPush(int elt)
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
        return new Iterator<Integer>() {
            private int currIndex = 0;

            @Override
            public boolean hasNext()
            {
                return currIndex < data.length - 1 && data[currIndex] != 0;
            }

            @Override
            public Integer next()
            {
                return data[currIndex++];
            }
        };
    }

    public static void main(String[] args)
    {
        Stack stack = new Stack();

        for(int i = 1; i < 6; i++)
            stack.push(i);

        System.out.println("Reallocation Popping: " + stack.reallocatePop());
        stack.optimisedPush(6);
        System.out.println("Popping: " + stack.pop());

        System.out.println("Is Empty? " + stack.isEmpty());
        System.out.println("Is Full? " + stack.isFull());
        System.out.println("Stack Length: " + stack.stackLength());

        for (Integer integer : stack) System.out.println(integer);

    }
}

