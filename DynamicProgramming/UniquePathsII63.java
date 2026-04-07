package Strivers_dsa.DynamicProgramming;

import java.util.Arrays;

public class UniquePathsII63 {
    int fun(int[][] grid,int i,int j,int[][] dp){
        if(i>=grid.length||j>=grid[0].length||grid[i][j]==1)
            return 0;
        if(i==grid.length-1&&j==grid[0].length-1)
            return 1;
        if(dp[i][j]==-1)
            dp[i][j]=fun(grid,i+1,j,dp)+fun(grid,i,j+1,dp);
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        return fun(obstacleGrid,0,0,dp);
    }
}
