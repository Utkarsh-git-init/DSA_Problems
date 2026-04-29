package Strivers_dsa.Graph;

public class NumberOfEnclaves1020 {
    boolean flag=true;
    public int numEnclaves(int[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        int[][] d={
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1&&visited[i][j]==0){
                    flag=true;
                    int temp=dfs(i,j,grid,visited,d);
                    if(flag) res+=temp;
                }
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] grid, int[][] visited, int[][] d) {
        if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1)
            flag = false;
        int count = 0;
        visited[i][j] = 1;
        for (int[] ints : d) {
            int ni = i + ints[0];
            int nj = j + ints[1];
            if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[ni].length && grid[ni][nj] == 1 && visited[ni][nj] == 0) {
                count += dfs(ni, nj, grid, visited, d);
            }
        }

        return count + 1;
    }
}
