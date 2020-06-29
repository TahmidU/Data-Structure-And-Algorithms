package data_structure.hash.chaining;

/**
 * Hash Table that uses Linked Lists on collisions.
 */
public class HashTableChaining
{
    private HashNode[] table;
    private int elements = 0;

    public HashTableChaining(int size)
    {
        table = new HashNode[size];
    }

    public float loadFactor()
    {
        return (float) elements/ (float) table.length;
    }

    private int hash(int key)
    {
        return key%table.length;
    }

    public void insert(int key, int value)
    {
        if(table[hash(key)] == null)
        {
            table[hash(key)] = new HashNode(key, value); // If its empty then simply add a new LinkedNode.
        }else
        {
            HashNode pointer = table[hash(key)];
            while(pointer != null)
            {
                if(pointer.key == key)
                {
                    pointer.value = value;
                    return;
                }
                pointer = pointer.next;
            }
           table[hash(key)] = new HashNode(key, value, table[hash(key)]); // New LinkedNode now head. Old Head is now Head.next.
        }

        elements++;
    }

    public Integer search(int key)
    {
        HashNode pointer = table[hash(key)];

        while(pointer != null)
        {
            if(pointer.key == key)
            {
                return pointer.value;
            }
            pointer = pointer.next;
        }

        return null;
    }

    public boolean delete(int key)
    {
        HashNode pointer = table[hash(key)];
        if(pointer.key == key)
        {
            table[hash(key)] = pointer.next;
            elements--;
            return true;
        }
        do
            {
                if(pointer.next.key == key)
                {
                    pointer.next = pointer.next.next;
                    elements--;
                    return true;
                }
                pointer = pointer.next;
            }while (pointer.next != null);
        return false;
    }

    public static void main(String[] args)
    {
        HashTableChaining htc = new HashTableChaining(10);
        htc.insert(10, 10);
        htc.insert(5, 5);
        htc.insert(10, 10);
        htc.insert(7, 5);
        htc.insert(10, 10);
        htc.insert(5, 5);
        htc.insert(10, 10);
        htc.insert(5, 5);
        System.out.println("Deleted 5? " + htc.delete(5));
        htc.insert(15, 15);
        System.out.println("Load Factor: " + htc.loadFactor());
        System.out.println("Found key 15? " + htc.search(15));
    }
}
