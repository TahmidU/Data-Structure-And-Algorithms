package stack;

public class Stack
{

    private int count = 0;
    private int[] data = new int[1];

    public boolean isEmpty()
    {
        return count == 0;
    }

    //Value will still be stored in the array but it will be overwritten during the push operation.
    public int pop()
    {
        count--;
        return data[count];
    }

    //Dynamically reduces the array size.
    //Advantage: Takes less space in memory.
    public void reallocatePop()
    {
        count--;
        int[] d1 = new int[data.length - 1]; //Create new array with -1 space than prev array.

        //Copy elements to new array.
        for(int i = 0; i < count; i++)
        {
            d1[i] = data[i];
        }
        data = d1;
    }

    //Amortised Cost O(n)
    public void push(int elt)
    {
        //If there's no space in the stack...
        if(count == data.length)
        {
            int[] d1 = new int[data.length + 1]; //Create a new array with +1 space than prev array.

            //Copy elements from the prev array to the new array.
            for(int i = 0; i < count; i++)
            {
                d1[i] = data[i];
            }
            data = d1;
        }
        //Place new values at the last position of array.
        data[count] = elt;
        count++;
    }

    //Amortised Cost: O(1)
    public void optimisedPush(int elt)
    {
        if(count == data.length)
        {
            int currentLength = data.length * 2;//Double the length
            int[] d1 = new int[currentLength];

            for(int i = 0; i < count; i++)
            {
                d1[i] = data[i];
            }
            data = d1;
        }


        data[count] = elt;
        count++;
    }

    public int stackLength()
    {
        return data.length;
    }

    public void print()
    {
        for(int i: data)
        {
            System.out.println(i);
        }
    }

}
