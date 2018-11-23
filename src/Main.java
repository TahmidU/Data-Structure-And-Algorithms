import heap.Heap;
import linked_lists.SinglyLinkedList;
import sort.HeapSort;
import stack.Stack;

public class Main
{

    public static void main(String args[])
    {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.addToHead(5);
        singlyLinkedList.addToHead(3);
        singlyLinkedList.addToHead(8);
        singlyLinkedList.addToHead(10);
        singlyLinkedList.addToHead(11);

        //singlyLinkedList.print();

        singlyLinkedList.deleteLastNode();
        singlyLinkedList.recursivePrint(singlyLinkedList.getHead());

    }

}
