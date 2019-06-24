import hash.HashTableLinearProbing;
import linked_lists.SinglyLinkedList;
import sort.HeapSort;

public class Main
{

    public static void main(String args[])
    {
        HashTableLinearProbing tbl = new HashTableLinearProbing(5);
        tbl.insert(0);

        System.out.println(tbl.getTable()[0]);
    }
}
