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

    public int deleteLastNode()
    {
        int elt = tail.info;

        if(head == tail)
            head = tail = null;
        else
            {
                Node temp = head;
                while(temp.next != tail)
                {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }

        return elt;
    }

    public void print()
    {
        Node point = head;

        while(point != null)
        {
            if(point.next != null)
                System.out.print(point.info+"->");
            else
                System.out.print(point.info);

            point = point.next;
        }
    }

    public Node recursivePrint(Node point)
    {
        Node aux = point;

        if(aux == null) {
            return null;
        }
        else {
            System.out.println(aux.info);
            return recursivePrint(point.next);
        }
    }

    public Node getHead()
    {
        return head;
    }

}
