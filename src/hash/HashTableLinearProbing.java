package hash;

import linked_lists.Node;

public class HashTableLinearProbing
{
    private Integer[] table; // So that we can use null.
    private int elements = 0;

    public HashTableLinearProbing(int size)
    {
        table = new Integer[size];
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
        for(int i = 0; i < table.length; i++)
        {
            // %table.length so that the loop loops back at the start of the array instead of going out of bound.
            if(table[(hash(key)+i)%table.length] == null)
            {
                table[(hash(key)+i)%table.length] = key;
                break;
            }
        }
        elements++;
    }

    public void search(int key)
    {
        int count = 0;

        for(int i = hash(key); table[i] != null; i = (i+1)%table.length)
        {
            // So that the loop does not go infinitely if the array is full.
            if (count == table.length)
            {
                break;
            }

            if(table[i] == key)
            {
                System.out.println("Found: " + key);
                return;
            }

            count++;
        }

        System.out.println("Key does not exist!");
    }

    public void delete(int key)
    {
        int count = 0;

        for(int i = hash(key); table[i] != 0; i = (i+1)%table.length)
        {
            if (count == table.length)
            {
                break;
            }

            if(table[i] == key)
            {
                table[i] = 0; // Placeholder used to show something was deleted. Otherwise probing wouldnt work properly.
                return;
            }

            count++;
        }

        System.out.println("Key does not exist!");
        elements--;
    }

    public void print()
    {
        for(int i = 0; i<table.length; i++)
        {
            System.out.println(table[i]);
        }
    }
}
