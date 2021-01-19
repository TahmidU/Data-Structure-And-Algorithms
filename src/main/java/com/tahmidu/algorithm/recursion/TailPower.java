package com.tahmidu.algorithm.recursion;

/**
 * Example of a Tail Recursive Algorithm.
 */
public class TailPower
{
    public TailPower(){}

    public int tailPower(int x, int n)
    {
        return power(x, n,1, 0);
    }

    private int power(int x, int n, int acc, int curDepth)
    {
        System.out.println("Recursive Depth: " + curDepth);
        System.out.println("Param x: " + x);
        System.out.println("Param n: " + n);
        System.out.println("Current Accumulation: " + acc);

        if(n == 0) return acc;//Base Case
        else return power(x, n-1, acc*x, curDepth+1);
    }

}
