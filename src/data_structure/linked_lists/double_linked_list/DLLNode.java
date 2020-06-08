package data_structure.linked_lists.double_linked_list;

public class DLLNode
{
    public int info;
    public DLLNode next, prev;

    public DLLNode(int i, DLLNode n, DLLNode p)
    {
        info = i;
        next = n;
        prev = p;
    }

    public DLLNode(int i)
    {
        this(i, null, null);
    }
}
