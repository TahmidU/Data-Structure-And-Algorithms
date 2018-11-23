package sort;

public class HeapSort
{
    public HeapSort(){}

    //Swap n1 and n2 element.
    private void swap(int[] data,int first,int larger)
    {
        int temp = 0;
        temp = data[first];
        data[first] = data[larger];
        data[larger] = temp;
    }

    //Find the nodes: left child, and right child.
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

    //Sort Array.
    public int[] heapsort(int[] data)
    {

        //First turn the array into a heap.
        for(int i = data.length/2 - 1; i>=0; i--)
        {
            moveDown(data, i, data.length);
        }


        //Begin sorting.
        for(int i = data.length - 1; i>=1; i--)
        {
            swap(data, 0, i); //Swap the root. Root would be always the max number.
            moveDown(data, 0, i); //heapify.
        }

        return data;
    }

}
