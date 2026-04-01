package Strivers_dsa.DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs70 {
    public int fun(int n,int[] dp){
        if(n<2)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        int temp1=fun(n - 1, dp);
        int temp2=fun(n - 2, dp);
        dp[n]=temp1+temp2;
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return fun(n,dp);
    }
}
