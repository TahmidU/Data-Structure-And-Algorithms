package com.tahmidu.data_structure.linked_lists;

/**
 * A linked list made of connected nodes - Unidirectional.
 */
public class SinglyLinkedList
{

    public LinkedNode head = null;
    public LinkedNode tail = null;

    public boolean isEmpty()
    {
        return head == null;
    }

    public void addToHead(int elt)
    {
        if(isEmpty()) {
            head = new LinkedNode(elt);
            tail = head;
        }else
            {
                head = new LinkedNode(elt, head);
            }
    }

    public void addToTail(int elt)
    {
        if(isEmpty())
        {
            tail = new LinkedNode(elt);
            head = tail;
        }else
            {
                tail.next = new LinkedNode(elt);
                tail = tail.next;
            }
    }

    public int deleteFromHead()
    {
        int elt = head.info;

        //If the list contains 1 or no elements.
        if(head == tail)
            head = tail = null;
        else //the head now points to the next node.
            head = head.next;

        return elt;
    }

    public int deleteLastNode()
    {
        int elt = tail.info;

        if(head == tail)
            head = tail = null;
        else
            {
                LinkedNode temp = head;
                while(temp.next != tail)
                {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }

        return elt;
    }

    public int deleteIndex(int index)
    {
        if(index == 0)
            return deleteFromHead();

        LinkedNode aux = head;
        for(int i = 0; i <= index; i++)
        {
            if(i + 1 == index)
            {
                if(aux.next == null)
                    throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
                if(aux.next == tail)
                    return deleteLastNode();

                int info = aux.next.info;
                aux.next = aux.next.next;
                return info;
            }
            aux = aux.next;
        }
        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
    }

    public void print()
    {
        LinkedNode point = head;

        while(point != null)
        {
            if(point.next != null)
                System.out.print(point.info+"->");
            else
                System.out.print(point.info+"\n");

            point = point.next;
        }
    }

    public static void main(String[] args)
    {
        SinglyLinkedList s = new SinglyLinkedList();

        s.addToHead(5);
        s.addToHead(10);
        s.addToTail(15);
        s.addToTail(20);
        System.out.println("Is empty? " + s.isEmpty());
        s.print();
        System.out.println("Deleted: " + s.deleteIndex(1));
        s.print();
    }

}
