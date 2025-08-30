package Strivers_dsa.Recursion;

public class Count_good_number_1922 {
    public static long calculatepow(long mod, int x, long n) {
        if (n == 1)
            return x;
        if (n % 2 == 0) {
            long temp = calculatepow(mod, x, n / 2) % mod;
            return (temp * temp) % mod;
        } else {
            return ((x)* (calculatepow(mod, x, n - 1) % mod))%mod;
        }
    }
    public static long countGoodNumbers(long n) {
        long odd, even;
        if (n % 2 == 0)
            even = odd = n / 2;
        else {
            odd = n / 2;
            even = odd + 1;
        }
        return calculatepow(1000000007, 5, even) * calculatepow(1000000007, 4, odd);
    }
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
        //System.out.println(calculatepow(1000000007,5,5));
    }
}