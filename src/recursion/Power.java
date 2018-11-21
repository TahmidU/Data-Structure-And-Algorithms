package recursion;

public class Power
{

    public Power(){}

    public int oldPower(int x, int n)
    {
        if(n == 0) return 1;
        else return x * oldPower(x, n-1);
    }

    public int newPower(int x, int n)
    {
        if(n == 0) return 1;
        if ((n % 2) == 0) {
            //System.out.println("even");
            return newPower(x, n / 2) * newPower(x, n / 2);
        } else {
            //System.out.println("odd");
            return x * newPower(x, (n - 1)/2) * newPower(x,(n-1)/2);
        }

    }

    public double avPower(double x, int n)
    {
        //System.out.println(p);
        if(n==0) return 1.0;
        double p = avPower(x, n/2);
        p *= p;
        if(n%2 != 0) {
            p *= x;
        }
        return p;
    }

}
