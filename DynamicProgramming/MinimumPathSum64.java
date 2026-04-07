package Strivers_dsa.DynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum64 {
    int fun(int[][] grid,int i,int j,int[][] dp){
        if(i>=grid.length||j>=grid[0].length)
            return Integer.MAX_VALUE;
        if(i==grid.length-1&&j==grid[0].length-1)
            return grid[i][j];
        if(dp[i][j]==-1)
            dp[i][j]=grid[i][j]+Math.min(fun(grid,i+1,j,dp),fun(grid,i,j+1,dp));
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return fun(grid,0,0,dp);
    }
}

