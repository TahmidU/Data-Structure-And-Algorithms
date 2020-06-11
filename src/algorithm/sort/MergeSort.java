package algorithm.sort;

public class MergeSort
{
    private int[] data;

    public MergeSort(int[] data)
    {
        this.data = data;
    }

    public int[] sort()
    {
        return mergeSort(data, data.length);
    }

    public int[] mergeSort(int[] data, int length) {
        //Array of length 1 is sorted.
        if (length < 2) {
            return data;
        }

        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        //Copy parts of the original array to left and right arrays.
        System.arraycopy(data, 0, left, 0, mid);
        System.arraycopy(data, mid, right, 0, length - mid);

        //Break down the left and right array further.
        mergeSort(left, mid);
        mergeSort(right, length - mid);

        return merge(data, left, right, mid, length - mid);
    }

    public int[] merge(int[] data, int[] left, int[] right, int start, int end) {

        //Sort the arrays into the original array.
        int i = 0, j = 0, k = 0;
        while (i < start && j < end) {
            if (left[i] <= right[j])
                data[k++] = left[i++];
            else
                data[k++] = right[j++];
        }

        //Place the remaining elements in the array.
        while (i < start)
            data[k++] = left[i++];

        while (j < end)
            data[k++] = right[j++];

        return data;
    }

    public static void main(String[] args)
    {
        MergeSort ms = new MergeSort(new int[]{200,0,40,15,8});
        for(int i : ms.sort()) System.out.print(i+" ");
    }
}
