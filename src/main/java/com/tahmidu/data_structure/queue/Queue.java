package com.tahmidu.data_structure.queue;

import java.util.Iterator;

/**
 * Linear Data Structure forming a FIFO queue.
 */
public class Queue implements Iterable<Integer>
{
    protected int[] data;
    protected int count = 0;

    public Queue(int size)
    {
        data = new int[size];
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public void add(int elt)
    {
        //Increment counter before placing param.
        if(count == data.length-1)
        {
            int[] d1 = new int[data.length*2];
            System.arraycopy(data, 0, d1, 0, count);
            data = d1;
        }
        data[count++] = elt;
    }

    public int extract()
    {
        //Highest number is highest priority (therefore placed last).
        int tempMax = data[0];
        data[0] = 0;

        int curr = 0;
        //Elements are shuffled up to prevent overwriting when add() is called.
        while(curr < data.length)
        {
            if(curr == data.length-1)
            {
                data[curr] = 0;
                count--;
                break;
            }else
            {
                swap(curr, curr + 1);
                curr++;
            }
        }
        return tempMax;
    }

    protected void swap(int e1, int e2)
    {
        int tempData = data[e1];
        data[e1] = data[e2];
        data[e2] = tempData;
    }

    public int size()
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
                return currIndex < data.length-1 && data[currIndex] != 0;
            }

            @Override
            public Integer next() {
                return data[currIndex++];
            }
        };
    }


}
