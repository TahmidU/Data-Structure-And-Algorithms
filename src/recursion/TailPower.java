package recursion;

public class TailPower
{
    public TailPower(){}

    public double tailPower(double x, double n)
    {
        return power(x, n,1);
    }

    private double power(double x, double n, double acc)
    {
        if(n == 0) return acc;//Base Case
        else return power(x, n-1, acc*x);
    }

}
