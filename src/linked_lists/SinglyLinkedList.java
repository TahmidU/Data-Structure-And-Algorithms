package linked_lists;

public class SinglyLinkedList
{

    private Node head = null;
    private Node tail = null;

    public boolean isEmpty()
    {
        return head == null;
    }

    public void addToHead(int elt)
    {
        if(isEmpty()) {
            head = new Node(elt);
            tail = head;
        }else
            {
                head = new Node(elt, head);
            }
    }

    public void addToTail(int elt)
    {
        if(isEmpty())
        {
            tail = new Node(elt);
            head = tail;
        }else
            {
                tail.next = new Node(elt);
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

    public void print()
    {
        while(head != null)
        {
            if(head.next != null)
                System.out.print(head.info+"->");
            else
                System.out.print(head.info);

            head = head.next;
        }
    }

}
