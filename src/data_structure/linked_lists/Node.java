package data_structure.linked_lists;

public class Node
{
    public int info;
    public Node next;

    public Node(int i, Node n)
    {
        info = i;
        next = n;
    }

    public Node(int i)
    {
        this(i,null);
    }
}
