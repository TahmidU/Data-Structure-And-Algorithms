package com.tahmidu.data_structure.tree.heap;

import java.util.Iterator;

/**
 * Heap tree data structure. Max Heap. Array implementation.
 */
public class Heap implements Iterable<Integer>
{
    /*
        A count is separate from data.length. The latter describes the length of the actual array, as for the former that
        describes the number of elements in the heap.
     */
    private int[] data;
    private int length = 0;

    public Heap(int size)
    {
        data = new int[size];
    }

    public Heap(int[] data)
    {
        if(data != null){
            this.data = data;
            length = data.length;
            buildMaxHeap();
        }
    }

    public Heap() {
    }

    public void add(int elt){

        length++;
        if(length >= data.length){
            int[] d1 = new int[data.length * 2];
            System.arraycopy(data, 0, d1, 0, length -1);
            data = d1;
        }

        int auxPos = length - 1;
        data[auxPos] = elt;

        while(auxPos > 0 && data[parent(auxPos)] < elt) {
            swap(parent(auxPos), auxPos);
            auxPos = parent(auxPos);
        }

    }

    public int extract(){

        int max = data[0];
        swap(length-1, 0);
        length--;

        buildMaxHeap();

        return max;
    }

    public void buildMaxHeap(){

        // Check every left and right node by parent...
        for(int i = ((length-1)/2); i >= 0; i--){

            if(!(left(i) >= length)) {
                if (data[i] < data[left(i)])
                    swap(i, left(i));
            }

            if(!(right(i) >= length)){
                if(data[i] < data[right(i)])
                    swap(i, right(i));
            }

        }

        // Max should be a the top, clean heap downwards...
        for(int i = 0; i < length; i++){

            if(!(left(i) >= length)) {
                if (data[i] < data[left(i)])
                    swap(i, left(i));
            }

            if(!(right(i) >= length)){
                if(data[i] < data[right(i)])
                    swap(i, right(i));
            }

        }

    }

    public int peek(){
        return data[0];
    }

    public boolean isEmpty()
    {
        return length == 0;
    }

    public int size()
    {
        return length;
    }

    private void swap(int firstIndex,int largerIndex)
    {
        int temp;
        temp = data[firstIndex];
        data[firstIndex] = data[largerIndex];
        data[largerIndex] = temp;
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

    public void setData(int[] data) {
        this.data = data;
        length = data.length;
        buildMaxHeap();
    }

    public int[] getData()
    {
        return data;
    }

    public int[] getHeapArray(){
        int[] newData = new int[length];
        if (length >= 0) System.arraycopy(data, 0, newData, 0, length);
        return newData;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            private int currIndex = 0;

            @Override
            public boolean hasNext()
            {
                return currIndex < length && data[currIndex] != 0;
            }

            @Override
            public Integer next() {
                return data[currIndex++];
            }
        };
    }
}
