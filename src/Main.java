import hash.HashTableChaining;
import hash.HashTableLinearProbing;
import hash.HashTableQuadProbing;
import heap.Heap;
import linked_lists.CircularList;
import linked_lists.SinglyLinkedList;
import linked_lists.double_linked_list.DoublyLinkedList;
import sort.HeapSort;
import stack.Stack;

public class Main
{

    public static void main(String args[])
    {
        HashTableQuadProbing hashTableQuadProbing = new HashTableQuadProbing(10);

        hashTableQuadProbing.insert(8);
        hashTableQuadProbing.insert(3);
        hashTableQuadProbing.insert(3);
        hashTableQuadProbing.insert(3);

        //hashTableQuadProbing.delete(3);

        hashTableQuadProbing.insert(2);


        hashTableQuadProbing.print();

    }

}
