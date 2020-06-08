package data_structure.tree.heap;

import java.util.Iterator;

/**
 * Heap tree data structure. Max Heap. Array implementation.
 */
public class Heap implements Iterable<Integer>
{
    private int[] data;
    private int count = 0;

    public Heap(int size)
    {
        data = new int[size];
    }

    public Heap(int[] data)
    {
        this.data = data;
        this.count = data.length - 1;
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    //Add the element.
    public void add(int elt)
    {
        if(count == data.length - 1)
        {
            int[] d1 = new int[data.length * 2];
            System.arraycopy(data, 0, d1, 0, count);
            data = d1;
        }

        int pos = count;

        //Check if the element is greater than the parent.
        while(pos > 0 && data[parent(pos)] < elt)
        {
            data[pos] = data[parent(pos)];
            pos = parent(pos);
        }

        data[pos] = elt;
        count++;
    }

    //Extract the root. Then shift the nodes till they are in the correct place.
    public int extract()
    {
        //Extract root.
        int max = data[0];
        data[0] = data[--count];
        data[count]=0;
        heapifyDown(0);
        return max;
    }

    public void maxToEnd() {
        //Extract root.
        int max = data[0];
        data[0] = data[count];
        data[count--] = max;
    }

    public void heapifyDown(int node)
    {
        //A left node will always exist if there's a right node due to the nature of the add function.
        if(!(right(node) > count)) {
            //If the left node is greater than the right then we do not need to compare the parent and right nodes.
            if (data[left(node)] > data[right(node)]) {
                if (data[node] < data[left(node)]) {
                    swap(node, left(node));
                    heapifyDown(left(node));
                }
            } else {
                if (data[node] < data[right(node)]) {
                    swap(node, right(node));
                    heapifyDown(right(node));
                }
            }
        }

        if(!(left(node) > count))
        {
            if (data[node] < data[left(node)]) {
                swap(node, left(node));
            }
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int currIndex = 0;

            @Override
            public boolean hasNext()
            {
                return currIndex < data.length-1 && data[currIndex] != 0;
            }

            @Override
            public Integer next() {
                return data[currIndex++];
            }
        };
    }

    //Find the nodes: parent, left child, and right child.
    private int parent(int n)
    {
        return (n-1)/2;
    }

    private int left(int n)
    {
        return (n*2)+1;
    }

    private int right(int n)
    {
        return (n*2)+2;
    }

    //Swap n1 and n2 element.
    private void swap(int first,int larger)
    {
        int temp;
        temp = data[first];
        data[first] = data[larger];
        data[larger] = temp;
    }

    public int size()
    {
        return data.length;
    }

    public int[] getData()
    {
        return data;
    }

    public void print()
    {
        for (int a: data)
        {
            System.out.println(a);
        }
    }

    public static void main(String[] args)
    {
        Heap heap = new Heap(5);

        heap.add(20);
        heap.add(19);
        heap.add(17);
        heap.add(18);
        heap.add(80);
        heap.add(49);
        heap.add(27);
        heap.add(98);
        heap.add(1);
        heap.add(2);
        heap.add(67);
        heap.add(28);
        heap.add(18);
        heap.add(12);
        heap.add(2);
        heap.add(11);
        heap.add(100);

        System.out.println("Extract max: " + heap.extract());
        for(int i : heap) System.out.println(i);
        System.out.println("Size: " + heap.size());
        System.out.println("Is empty? " + heap.isEmpty());
    }
}
