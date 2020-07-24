package algorithm.search;

/**
 * Linear Search Algorithm. Can search through both sorted and unsorted arrays.
 */
public class LinearSearch
{
    public boolean search(int elt, int[] arr)
    {
        for(int i : arr)
            if(i == elt)
                return true;

        return false;
    }

    public static void main(String[] args)
    {
        int[] arr = {2,3,4,1};
        System.out.println("Exists in array? " + new LinearSearch().search(0, arr));
    }
}
