package Strivers_dsa.Graph;


import java.sql.PreparedStatement;
import java.util.ArrayDeque;
import java.util.Queue;

//problem 524. 01 Matrix
public class Matrix524 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Integer> rowQueue=new ArrayDeque<>();
        Queue<Integer> colQueue=new ArrayDeque<>();
        int[][] d={
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };
        int[][] res=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=0)
                    res[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res.length;j++){
                if(res[i][j]==0) {
                    rowQueue.add(i);
                    colQueue.add(j);
                }
            }
        }
        bfs(res, rowQueue, colQueue,d);
        return res;
    }

    private void bfs(int[][] res, Queue<Integer> rowQueue, Queue<Integer> colQueue,int[][] d) {
        while (!rowQueue.isEmpty()){
            int row=rowQueue.poll();
            int col=colQueue.poll();
            int count=res[row][col];
            count++;
            for(int i=0;i<4;i++){
                int nRow=row+d[i][0];
                int nCol=col+d[i][1];
                if(nRow<res.length&&nRow>=0&&nCol>=0&&nCol<res[0].length&&res[nRow][nCol]>count){
                    rowQueue.add(nRow);
                    colQueue.add(nCol);
                    res[nRow][nCol]=count;
                }
            }
        }
    }
}
