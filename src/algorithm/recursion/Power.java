package algorithm.recursion;

/**
 * Example of a Recursive algorithm.
 */
public class Power
{

    public Power(){}

    public double power(int x, int n, int accDepth)
    {
        //Print helpers to follow along.
        System.out.println("Recursive Depth: " + accDepth);
        System.out.println("Param x: " + x);
        System.out.println("Param n: " + n);

        //Base case
        if(n==0) return 1.0;
        double p = power(x, n/2, accDepth+1);

        p *= p; //If n even then: power()*power(). x^2n = x^n * x^n.

        //If n is odd then: power()*power()*x. x^(2n+1) = x^n * x^n * x.
        if(n%2 != 0) {
            p *= x;
        }
        return p;
    }

    public static void main(String[] args)
    {
        System.out.println("Answer: " + new Power().power(5,3,0));
    }

}
