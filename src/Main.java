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
        CircularList c1 = new CircularList();
        CircularList c2 = new CircularList();

        c1.addToHead(3);
        c1.addToHead(2);
        c1.addToHead(6);
        c1.addToHead(5);

        c2.addToHead(9);
        c2.addToHead(1);
        c2.addToHead(11);
        c2.addToHead(50);

        CircularList c3 = new CircularList();

        c3 = c3.orderedList(c1, c2);

        c3.print();
        //circularList.addToHead(500);
        //circularList.addToHead(6);
        //circularList.addToHead(89);
        //circularList.addToHead(9);

        //System.out.println(circularList.findMax());

    }

}
