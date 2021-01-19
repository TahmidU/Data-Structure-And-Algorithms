package com.tahmidu.data_structure.linked_lists;

import java.util.Iterator;

/**
 * A linked list that forms a bunch of circularly connected nodes (last node connected to the first node).
 */
public class CircularList implements Iterable<LinkedNode>
{
    public LinkedNode tail = null;

    public boolean isEmpty()
    {
        return tail == null;
    }

    public void addToHead(int elt)
    {
        if(isEmpty())
        {
            //Create a new LinkedNode then point to itself.
            tail = new LinkedNode(elt);
            tail.next = tail;
        }else
            {
                //tail.next now points to a new node.
                //Make the new node point to what the previous tail.next was point to.
                tail.next = new LinkedNode(elt, tail.next);
            }
    }

    public void addToTail(int elt)
    {
        addToHead(elt);
        tail = tail.next; //Tail points to where ever the last LinkedNode is pointing to (the first node).
    }

    public int deleteFromHead()
    {
        int elt = tail.next.info;

        if(tail == tail.next)
            tail = null; //If there's one LinkedNode in the list.
        else
            {
                tail.next = tail.next.next; //Make pointer point to the LinkedNode that the Head was pointing to.
            }
        return elt;
    }

    @Override
    public Iterator<LinkedNode> iterator() {
        return new Iterator<LinkedNode>() {
            LinkedNode p = tail;
            boolean tailVisited = false;

            @Override
            public boolean hasNext()
            {
                return !tailVisited;
            }

            @Override
            public LinkedNode next() {
                if(p.next == tail)
                    tailVisited = true;
                p = p.next;
                return p;
            }
        };
    }

    public static void main(String[] args)
    {
        CircularList circularList = new CircularList();
        circularList.addToHead(5);
        circularList.addToHead(2);
        circularList.addToTail(10);
        circularList.addToHead(11);
        circularList.deleteFromHead();
        for(LinkedNode c : circularList) System.out.println(c.info);

        //Find Max - Example
        LinkedNode pointer = circularList.tail;
        int tempMax = 0;

        if(!circularList.isEmpty()) {
            do {
                pointer = pointer.next;

                if (pointer.info > tempMax)
                    tempMax = pointer.info;

            } while (pointer != circularList.tail);
        }

        System.out.println("Max: " + tempMax);
    }
}
