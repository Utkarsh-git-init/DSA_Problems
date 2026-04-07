package Strivers_dsa.DynamicProgramming;

import java.util.Arrays;

public class HouseRobberII213 {
    int fun(int[] nums, int i,int n,int[] dp){
        if(i>=n)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int temp1=fun(nums,i+2,n,dp);
        int temp2=fun(nums,i+3,n,dp);
        dp[i]=nums[i]+Math.max(temp1,temp2);
        return dp[i];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        int[] dp=new int[nums.length];
        int[] dp2=new int[nums.length-1];
        Arrays.fill(dp,-1);
        Arrays.fill(dp2,-1);
        return Math.max(Math.max(fun(nums,0,n-1,dp2),fun(nums,2,n,dp)),fun(nums,1,n,dp));
    }
}
