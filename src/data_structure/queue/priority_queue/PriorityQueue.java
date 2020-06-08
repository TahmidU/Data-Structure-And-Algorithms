package data_structure.queue.priority_queue;

import data_structure.queue.Queue;

/**
 * Simple sorted Priority Queue that priorities based on max size.
 */
public class PriorityQueue extends Queue implements Iterable<Integer>
{
    public PriorityQueue(int size)
    {
        super(size);
    }

    @Override
    public void add(int elt)
    {
        //Increment counter before placing param.
        if(count == data.length-1)
        {
            int[] d1 = new int[data.length*2];
            System.arraycopy(data, 0, d1, 0, count);
            data = d1;
        }
        insert(count++, elt);
    }

    private void insert(int count, int elt)
    {
        int position = 0;
        //Find a position for the element. Loop till the new element is not
        //greater than the element its currently on. Array sorted lowest to largest.
        while(position < count && data[position] > elt) position++;

        //Shift elements up the elements that greater than
        //the new element.
        int place = count;
        while(place>position)
        {
            data[place] = data[place-1];
            place--;
        }

        //Place the new element in its rightful position.
        data[position] = elt;
    }

    public static void main(String[] args)
    {
        PriorityQueue PQ = new PriorityQueue(5);
        PQ.add(5);
        PQ.add(7);
        PQ.add(6);
        PQ.add(5);
        PQ.add(7);
        PQ.add(6);
        PQ.add(5);
        PQ.add(7);
        PQ.add(6);

        System.out.println("Empty? " + PQ.isEmpty());
        System.out.println("Size: " + PQ.size());
        System.out.println("Extract Max: " + PQ.extract());

        for (Integer integer : PQ) System.out.println(integer);
    }
}
