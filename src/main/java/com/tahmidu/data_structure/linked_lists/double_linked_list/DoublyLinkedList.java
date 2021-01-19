package com.tahmidu.data_structure.linked_lists.double_linked_list;

/**
 * A linked list made of connected nodes - bidirectional.
 */
public class DoublyLinkedList
{
    private DLLNode head = null;
    private DLLNode tail = null;

    public boolean isEmpty()
    {
        return head != null;
    }

    public void addToHead(int elt)
    {
        if(isEmpty())
        {
            head = new DLLNode(elt, head, null); //Make a new Head and point this new Head to the old Head.
            head.next.prev = head; //Point the prev of head.next to the new Head.
        }else
            {
                head = tail = new DLLNode(elt);
            }
    }

    public void addToTail(int elt)
    {
        if(isEmpty())
        {
            tail = new DLLNode(elt, null, tail); //Make a new Tail and point this new Tail to the old Tail.
            tail.prev.next = tail; //Point the next of tail.prev to the new Tail.
        }else
            {
                head = tail = new DLLNode(elt);
            }
    }

    public int deleteFromHead()
    {
        int elt = head.info;

        //If one LinkedNode exists
        if(head == tail)
            head = tail = null;
        else
            {
                head = head.next; //Make the 2nd LinkedNode the new Head.
                head.prev = null; //The new Heads prev points to null.
            }

        return elt;
    }

    public int deleteFromTail()
    {
        int elt = tail.info;

        //If one LinkedNode exists
        if(head == tail)
            head = tail = null;
        else
            {
                tail = tail.prev; //Make the 2nd last LinkedNode the new Tail.
                tail.next = null; //The new Tail points to null.
            }

        return elt;
    }

    public void deleteFirstNodeContaining(int i)
    {
        DLLNode pointer = head;

        while(pointer != null)
        {
            if(pointer.info == i)
            {
                if(pointer.next != null)
                    pointer.next.prev = pointer.prev; //The previous of the next node would be the previous of the current node.

                    //Special Case if the head contains the i. The 2nd node would become the new head.
                    if(pointer == head)
                        head = pointer.next;

                if(pointer.prev != null)
                    pointer.prev.next = pointer.next; //The next of the previous node would be the next of the current node.

                    //Special Case if the tail contains the i. The 2nd last node would become the new tail.
                    if(pointer == tail)
                        tail = pointer.prev;

                //Make the current node point to nothing in both directions.
                pointer.next = null;
                pointer.prev = null;
            }

            pointer = pointer.next;
        }
    }

    public int deleteIndex(int index)
    {
        if(index == 0)
            return deleteFromHead();

        int count = 0;
        DLLNode aux = head;
        do
            {
                if(count + 1 == index)
                {
                    int info = aux.next.info;

                    if(aux.next == tail)
                        return deleteFromTail();

                    aux.next = aux.next.next;
                    aux.next.prev = aux;
                    return info;
                }
                count++;

                aux = aux.next;
            }while (aux.next != null);

        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
    }

    public void printForward()
    {
        DLLNode point = head;

        while(point != null)
        {
            if(point.next != null)
                System.out.print(point.info+"<->");
            else
                System.out.print(point.info+"\n");

            point = point.next;
        }
    }

    public void printBackward()
    {
        DLLNode point = tail;

        while(point != null)
        {
            if(point.prev != null)
                System.out.print(point.info+"<->");
            else
                System.out.print(point.info+"\n");

            point = point.prev;
        }
    }

    public static void main(String args[])
    {
        DoublyLinkedList d = new DoublyLinkedList();

        System.out.println("Is empty? " + d.isEmpty());

        d.addToTail(5);
        d.addToHead(10);
        d.addToTail(15);
        d.addToTail(11);

        d.printForward();
        d.printBackward();

        System.out.println("Deleted: " + d.deleteIndex(3));
        d.printForward();
    }

}
