package linked_lists;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CircularList
{
    public Node tail = null;

    public boolean isEmpty()
    {
        return tail == null;
    }

    public void addToHead(int elt)
    {
        if(isEmpty())
        {
            //Create a new Node then point to itself.
            tail = new Node(elt);
            tail.next = tail;
        }else
            {
                //tail.next now points to a new node.
                //Make the new node point to what the previous tail.next was point to.
                tail.next = new Node(elt, tail.next);
            }
    }

    public void addToTail(int elt)
    {
        addToHead(elt);
        tail = tail.next; //Tail points to where ever the last Node is pointing to (the first node).
    }

    public int deleteFromHead()
    {
        int elt = tail.next.info;

        if(tail == tail.next)
            tail = null; //If there's one Node in the list.
        else
            {
                tail.next = tail.next.next; //Make pointer point to the Node that the Head was pointing to.
            }
        return elt;
    }

    public void print()
    {
        if(!isEmpty())
        {
            Node p = tail;

            //You have to remember that these nodes do not contain null in next.
            do
                {
                    p = p.next; //Start from the head.
                    System.out.println(p.info);
                }while (p != tail); //Print till it reaches the tail.
        }
    }

    public int findMax()
    {
        Node pointer = tail;
        int tempMax = 0;

        if(!isEmpty()) {
            do {
                pointer = pointer.next;

                if (pointer.info > tempMax)
                    tempMax = pointer.info;

            } while (pointer != tail);
        }
        return tempMax;
    }
}
