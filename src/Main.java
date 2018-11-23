import heap.Heap;
import linked_lists.SinglyLinkedList;
import sort.HeapSort;
import stack.Stack;

public class Main
{

    public static void main(String args[])
    {
        Heap heap = new Heap(5);

        heap.add(4);
        heap.add(3);
        heap.add(8);
        heap.add(2);
        heap.add(1);

        //heap.print();

        int[] a = {5,2,3,1,7};

        heap.heapify(a);
        heap.print();

    }

}
