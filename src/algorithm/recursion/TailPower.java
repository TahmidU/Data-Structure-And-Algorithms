package algorithm.recursion;

/**
 * Example of a Tail Recursive algorithm.
 */
public class TailPower
{
    public TailPower(){}

    public double tailPower(double x, double n)
    {
        return power(x, n,1, 0);
    }

    private double power(double x, double n, double acc, int curDepth)
    {
        System.out.println("Recursive Depth: " + curDepth);
        System.out.println("Param x: " + x);
        System.out.println("Param n: " + n);
        System.out.println("Current Accumulation: " + acc);

        if(n == 0) return acc;//Base Case
        else return power(x, n-1, acc*x, curDepth+1);
    }

    public static void main(String[] args)
    {
        System.out.println("Answer: " + new TailPower().tailPower(5,3));
    }

}
