package hash;

import linked_lists.Node;

public class HashTableChaining
{
    private Node[] table;
    private int elements = 0;

    public HashTableChaining(int size)
    {
        table = new Node[size];
    }

    public int loadFactor()
    {
        return elements/table.length;
    }

    private int hash(int key)
    {
        return key%table.length;
    }

    public void insert(int key)
    {
        if(table[hash(key)] == null)
        {
            table[hash(key)] = new Node(key); // If its empty then simply add a new Node.
        }else
        {
           table[hash(key)] = new Node(key, table[hash(key)]); // New Node now head. Old Head is now Head.next.
        }

        elements++;
    }

    public void search(int key)
    {
        // table[hash(key)] is the head.

        Node pointer = table[hash(key)];

        while (pointer != null)
        {
            if(pointer.info == key)
            {
                System.out.println("Found: " + key);
                return;
            }

            pointer = pointer.next;
        }

        System.out.println("Key does not exist!");
    }

    public void delete(int key)
    {
        Node pointer = table[hash(key)];

        while (pointer != null)
        {
            if(pointer.next != null && pointer.next.info == key)
            {
                pointer.next = pointer.next.next;
                return;
            }

            pointer = pointer.next;
        }

        elements--;
    }

}
