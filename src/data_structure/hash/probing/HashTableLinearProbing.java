package data_structure.hash.probing;

import java.security.KeyException;

/**
 * Simple Hash Table data structure where data is stored and retrieved using hashed values.
 */
public class HashTableLinearProbing
{
    private Integer[] table;
    private int elements = 0;

    public HashTableLinearProbing(){table = new Integer[10];}

    public HashTableLinearProbing(int size)
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
            int position = (hashed + i)%table.length;
            if(table[position] == null)
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
        for(int i = hash(key); table[i] != null; i = (i+1) % table.length)
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
        for(int i = hash(key); table[i] != 0 ; i = (i+1) % table.length)
        {
            if (count == table.length)
                throw new KeyException("Key does not exist!");

            if(table[i] != 0) {
                table[i] = 0; // Placeholder used to show something was deleted. Otherwise probing wouldnt work properly.
                elements--;
                return true;
            }

            count++;
        }
        throw new KeyException("Key does not exist!");
    }

    public static void main(String[] args) throws KeyException {
        HashTableLinearProbing htlp = new HashTableLinearProbing(10);
        htlp.insert(10, 10);
        htlp.insert(5, 5);
        htlp.insert(10, 10);
        htlp.insert(5, 5);
        htlp.insert(10, 10);
        htlp.insert(5, 5);
        htlp.insert(10, 10);
        htlp.insert(5, 5);
        System.out.println("Deleted 5? " + htlp.delete(5));
        htlp.insert(15, 15);
        System.out.println("Load Factor: " + htlp.loadFactor());
        System.out.println("Found key 15? " + htlp.search(15));
    }
}
