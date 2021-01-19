package com.tahmidu.data_structure.hash.chaining;

public class HashNode
{
    int key;
    int value;
    public HashNode next;

    public HashNode(int key, int value, HashNode next)
    {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
    }
}
