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
        //Increment counter before placing param.
        insert(data,count++,elt);
    }

    public int extractMax()
    {
        //Highest number is highest priority (therefore placed last).
        return data[--count];
    }

    private void insert(int[] data, int count, int elt)
    {
        int position = 0;
        //Find a position for the element. Loop till the new element is not
        //greater than the element its currently on. Array sorted lowest to largest.
        while(position < count && data[position] < elt) position++;

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

    public void print()
    {
        for(int i: data)
        {
            System.out.println(i);
        }
    }

}
