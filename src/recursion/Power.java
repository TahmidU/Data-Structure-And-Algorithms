package recursion;

public class Power
{

    public Power(){}

    public int oldPower(int x, int n)
    {

        if(n == 0) return 1;//Base Case
        else return x * oldPower(x, n-1);
    }

    public double newPower(int x, int n)
    {
        //Base case
        if(n==0) return 1.0;
        double p = newPower(x, n/2);

        p *= p; //If n even then: newPower()*newPower(). x^2n = x^n * x^n.

        //If n is odd then: newPower()*newPower()*x. x^(2n+1) = x^n * x^n * x.
        if(n%2 != 0) {
            p *= x;
        }
        return p;

    }


}
