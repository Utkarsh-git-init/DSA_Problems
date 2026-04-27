package Strivers_dsa.Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RottingOranges994 {
    int bfs(int[][] grid,int[][] visited,Queue<int[]> queue){
        int count=0;
        while (!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                int[] pos=queue.poll();
                int x=pos[0];
                int y=pos[1];
                if(x+1<grid.length&&visited[x+1][y]==0&&grid[x+1][y]==1) {
                    queue.add(new int[]{x + 1, y});
                    visited[x+1][y]=1;
                }
                if(x-1>=0&&visited[x-1][y]==0&&grid[x-1][y]==1) {
                    queue.add(new int[]{x - 1, y});
                    visited[x-1][y]=1;
                }
                if(y-1>=0&&visited[x][y-1]==0&&grid[x][y-1]==1) {
                    queue.add(new int[]{x, y - 1});
                    visited[x][y-1]=1;
                }
                if(y+1<grid[x].length&&visited[x][y+1]==0&&grid[x][y+1]==1) {
                    queue.add(new int[]{x, y + 1});
                    visited[x][y+1]=1;
                }
            }
            count++;
        }
        return count-1;
    }
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue=new ArrayDeque<>();
        int[][] visited=new int[grid.length][grid[0].length];
        for(int[] ints:visited)
            Arrays.fill(ints,0);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
            }
        }
        int count=bfs(grid,visited,queue);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(visited[i][j]==0&&grid[i][j]==1)
                    return -1;
            }
        }
        return count==-1?0:count; //if neither rotten nor fresh oranges are present
    }
}
/*
public class RottingOranges994 {
    int bfs(int[][] grid,Queue<int[]> queue){
        int count=0;
        while (!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                int[] pos=queue.poll();
                int x=pos[0];
                int y=pos[1];
                if(x+1<grid.length&&grid[x+1][y]==1) {
                    queue.add(new int[]{x + 1, y});
                    grid[x+1][y]=2;
                }
                if(x-1>=0&&grid[x-1][y]==1) {
                    queue.add(new int[]{x - 1, y});
                    grid[x-1][y]=2;
                }
                if(y-1>=0&&grid[x][y-1]==1) {
                    queue.add(new int[]{x, y - 1});
                    grid[x][y-1]=2;
                }
                if(y+1<grid[x].length&&grid[x][y+1]==1) {
                    queue.add(new int[]{x, y + 1});
                    grid[x][y+1]=2;
                }
            }
            count++;
        }
        return count-1;
    }
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue=new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
            }
        }
        int count=bfs(grid,queue);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return count==-1?0:count; //if neither rotten nor fresh oranges are present
    }
}
 */