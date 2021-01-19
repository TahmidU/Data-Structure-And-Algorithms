package com.tahmidu.data_structure.linked_lists;

public class LinkedNode
{
    public int info;
    public LinkedNode next;

    public LinkedNode(int i, LinkedNode n)
    {
        info = i;
        next = n;
    }

    public LinkedNode(int i)
    {
        this(i,null);
    }
}
