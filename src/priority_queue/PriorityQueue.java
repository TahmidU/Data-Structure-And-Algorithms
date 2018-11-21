package priority_queue;

public class PriorityQueue
{

    private int[] data; //Holds the elements
    private int count = 0; //Counts how many elements currently in array

    public PriorityQueue(int size)
    {
        data = new int[size];
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public void add(int elt)
    {
        insert(data,count++,elt);
    }

    public int extractMax()
    {
        return data[--count];
    }

    public void print()
    {
        for(int i: data)
        {
            System.out.println(i);
        }
    }

    private void insert(int[] data, int count, int elt)
    {
        int position = 0;
        while(position < count && data[position] < elt) position++;

        int place = count;
        while(place>position)
        {
            data[place] = data[place-1];
            place--;
        }
        data[position] = elt;
    }

}
