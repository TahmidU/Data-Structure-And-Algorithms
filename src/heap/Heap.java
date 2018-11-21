package heap;

public class Heap
{
    private int[] data;
    private int count = 0;

    public Heap(int size)
    {
        data = new int[size];
    }

    public Heap(){}

    public boolean isEmpty()
    {
        return count == 0;
    }

    //Add the element.
    public void add(int elt)
    {
        int pos = count;

        //Check if the element is greater than the parent. If it is then reposition the node till its in...
        //the correct position.
        while(pos > 0 && data[parent(pos)] < elt)
        {
            data[pos] = data[parent(pos)];
            pos = parent(pos);
        }

        data[pos] = elt;
        count = count + 1;
    }

    //Extract the root. Then shift the nodes till they are in the correct place.
    public int extractMax()
    {
        //Extract root.
        int max = data[0];

        data[0] = data[count-1];
        count = count - 1;

        //Sort the nodes
        moveDown(data,0,count);
        data[count]=0;
        return max;
    }

    //Find the nodes: parent, left child, and right child.
    private int parent(int n)
    {
        return (n-1)/2;
    }

    private int left(int n)
    {
        return (n*2)+1;
    }

    private int right(int n)
    {
        return (n*2)+2;
    }

    //Place nodes in correct position.
    private void moveDown(int[] data,int first, int last)
    {

        int current = first;
        while ((current * 2) + 1 < last)
        {
            int leftChild = left(current);
            int rightChild = right(current);

            if(leftChild < last && data[current] < data[leftChild])
            {
                current = leftChild;
            }
            if(rightChild < last && data[current] < data[rightChild])
            {
                current = rightChild;
            }
            if(current != first)
            {
                swap(data, current, first);
                first = current;
            }else
                {
                    break;
                }
        }

    }

    //Swap n1 and n2 element.
    private void swap(int[] data,int first,int larger)
    {
        int temp = 0;
        temp = data[first];
        data[first] = data[larger];
        data[larger] = temp;
    }

    public void print()
    {
        for(int i: data)
        {
            System.out.println(i);
        }
    }
}
