package Strivers_dsa.Recursion;

public class Pow_50 {
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(n<0)
            return 1/myPow(x,-n);
        if(n%2==0){
            n/=2;
            double half=myPow(x,n);
            return half*half;
        }else
            return myPow(x,n-1);
    }
}
/*
// stack overflow
public double pow(double x, int n){
        if(n>0)
            return x*myPow(x,n-1);
        else
            return 1;
    }
    public double myPow(double x, int n) {
        int m=n;
        if(n<0)
            n*=-1;
        double res=pow(x,n);
        if(m<0)
            res=1/res;
        return res;
    }
 */
