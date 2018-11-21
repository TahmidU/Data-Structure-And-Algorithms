package priority_queue;

public class UnsortedPriorityQueue
{
    private int[] data;
    private int count = 0;

    public UnsortedPriorityQueue(int size)
    {
        data = new int[size];
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public void add(int elt)
    {
        insert(data,count++, elt);
    }

    private void insert(int[] data, int count, int elt)
    {
        data[count] = elt;
    }

    public int extractMax()
    {
        int tempMax = 0;
        for(int i : data)
        {
            if(i > tempMax)
            tempMax = i;
        }
        return tempMax;
    }

    public void print()
    {
        for(int i: data)
        {
            System.out.println(i);
        }
    }
}
