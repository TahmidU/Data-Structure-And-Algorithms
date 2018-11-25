package linked_lists.double_linked_list;

public class DoublyLinkedList
{
    private DLLNode head = null;
    private DLLNode tail = null;

    public boolean isEmpty()
    {
        return head == null;
    }

    public void addToHead(int elt)
    {
        if(!isEmpty())
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
        if(!isEmpty())
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

        //If one Node exists
        if(head == tail)
            head = tail = null;
        else
            {
                head = head.next; //Make the 2nd Node the new Head.
                head.prev = null; //The new Heads prev points to null.
            }

        return elt;
    }

    public int deleteFromTail()
    {
        int elt = tail.info;

        //If one Node exists
        if(head == tail)
            head = tail = null;
        else
            {
                tail = tail.prev; //Make the 2nd last Node the new Tail.
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

    public void delete(DLLNode p)
    {
        if(p.prev == null)
            head = p.next;
        else
            p.prev.next = p.next;

        if(p.next == null)
            tail = p.prev;
        else
            p.next.prev = p.prev;
    }

    public void printForward()
    {
        DLLNode pointer = head;

        while (pointer != null)
        {
            System.out.println(pointer.info);
            pointer = pointer.next;
        }
    }

    public void printBackward()
    {
        DLLNode pointer = tail;

        while (pointer != null)
        {
            System.out.println(pointer.info);
            pointer = pointer.prev;
        }
    }

    public int findMax()
    {
        DLLNode pointer = head;
        int tempMax = 0;

        while (pointer != null)
        {
            if(pointer.info > tempMax)
                tempMax = pointer.info;

            pointer = pointer.next;
        }

        return tempMax;
    }



}
