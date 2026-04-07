package Strivers_dsa.DynamicProgramming;


import java.util.Arrays;

public class UniquePaths62 {
    int recursion(int i,int j,int m,int n,int[][] dp){
        if(i>=m||j>=n)
            return 0;
        if(i==m-1&&j==n-1)
            return 1;
        if(dp[i][j]==-1)
            dp[i][j]=recursion(i+1,j,m,n,dp)+recursion(i,j+1,m,n,dp);
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);
        return recursion(0,0,m,n,dp);
    }

}
