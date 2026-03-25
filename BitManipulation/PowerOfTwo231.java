package Strivers_dsa.BitManipulation;

public class PowerOfTwo231 {
    public boolean isPowerOfTwo(int n) {
        if(n<1)
            return false;
        return (n&(n-1))==0;
    }
}
