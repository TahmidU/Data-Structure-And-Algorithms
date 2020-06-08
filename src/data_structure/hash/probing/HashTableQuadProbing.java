package data_structure.hash.probing;

import java.security.KeyException;

/**
 * Only difference between this class and Linear Probing is that the hash(key) is now added with i^2 (since its quad)
 * instead of i+1.
 */
public class HashTableQuadProbing
{
    private Integer[] table; // So that we can use null.
    private int elements = 0;

    public HashTableQuadProbing()
    {
        table = new Integer[10];
    }

    public HashTableQuadProbing(int size)
    {
        table = new Integer[size];
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
        //Extend Array
        if(elements == table.length)
        {
            Integer[] d1 = new Integer[table.length * 2];
            System.arraycopy(table, 0, d1, 0, elements);
            table = d1;
        }

        int hashed = hash(key);
        for(int i = 0; i < table.length; i++)
        {
            int position = (hashed + i*i)%table.length;
            if(table[position] == null || table[position] == 0)
            {
                table[position] = value;
                break;
            }

            if(table[position] == value)
                return;
        }
        elements++;
    }

    public boolean search(int key)
    {
        int count = 0;
        for(int i = hash(key); table[i] != null && table[i] != 0; i = (i + (count*count)) % table.length)
        {
            // So that the loop does not go infinitely if the array is full.
            if (count == table.length)
                return false;
            count++;
        }
        return true;
    }

    public boolean delete(int key) throws KeyException {
        int count = 0;
        for(int i = hash(key); table[i] != 0; i = (i + (count*count)) % table.length)
        {
            if (count == table.length)
                throw new KeyException("Key does not exist!");

            if(table[i] != 0)
            {
                table[i] = 0; // Placeholder used to show something was deleted. Otherwise probing wouldnt work properly.
                elements--;
                return true;
            }

            count++;
        }
        throw new KeyException("Key does not exist!");
    }

    public static void main(String[] args) throws KeyException {
        HashTableQuadProbing htqp = new HashTableQuadProbing(10);
        htqp.insert(10, 10);
        htqp.insert(5, 5);
        htqp.insert(10, 10);
        htqp.insert(5, 5);
        htqp.insert(10, 10);
        htqp.insert(5, 5);
        htqp.insert(10, 10);
        htqp.insert(5, 5);
        System.out.println("Deleted 5? " + htqp.delete(5));
        htqp.insert(15, 15);
        System.out.println("Load Factor: " + htqp.loadFactor());
        System.out.println("Found key 15? " + htqp.search(15));

    }
}
