package Strivers_dsa.DynamicProgramming;

import java.util.Arrays;

public class HouseRobber198 {
    public int fun(int[] nums,int i,int[] dp){
        if(i>=nums.length)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int temp1=fun(nums,i+2,dp);
        int temp2=fun(nums,i+3,dp);
        dp[i]=nums[i]+Math.max(temp1,temp2);
        return dp[i];
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp, -1);
        return Math.max(fun(nums,0,dp),fun(nums,1,dp));
    }
}
