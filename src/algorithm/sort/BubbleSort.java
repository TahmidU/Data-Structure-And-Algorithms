package algorithm.sort;

/**
 * Bubble Sort that solves in increasing order and only deals with integers.
 */
public class BubbleSort
{
    private int[] data;

    public BubbleSort(int[] data)
    {
        this.data = data;
    }

    public int[] sort()
    {
        for(int i = 0; i < data.length; i++)
        {
            for(int j = 0; j < data.length; j++)
            {
                if(data[i] < data[j])
                {
                    swap(i, j);
                }
            }
        }
        return data;
    }

    private void swap(int pos1, int pos2)
    {
        int temp;
        temp = data[pos2];
        data[pos2] = data[pos1];
        data[pos1] = temp;
    }

    public static void main(String[] args)
    {
        BubbleSort bubbleSort = new BubbleSort(new int[]{1,3,4,2,1,23,9});
        for(int i : bubbleSort.sort())
        {
            System.out.print(i + " ");
        }

    }
}
