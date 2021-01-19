package com.tahmidu.data_structure.queue.priority_queue;

import com.tahmidu.data_structure.queue.Queue;

/**
 * Simple unsorted Priority Queue that priorities based on max size.
 */
public class UnsortedPriorityQueue extends Queue implements Iterable<Integer>
{
    public UnsortedPriorityQueue(int size)
    {
        super(size);
    }

    @Override
    public int extract()
    {
        int tempMax = 0;
        for(int i = 0; i < data.length - 1; i++)
        {
            if(data[i] > tempMax)
            {
                tempMax = data[i];
                int curr = i;
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
        }
        return tempMax;
    }

    public static void main(String[] args)
    {
        UnsortedPriorityQueue UPQ = new UnsortedPriorityQueue( 5);

        System.out.println("Is Empty? " + UPQ.isEmpty());
        UPQ.add(5);
        UPQ.add(2);
        System.out.println("Is Empty? " + UPQ.isEmpty());
        System.out.println("Extract Max: " + UPQ.extract());
        UPQ.add(7);

        for (Integer integer : UPQ) System.out.println(integer);
    }
}
