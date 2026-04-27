package Strivers_dsa.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Integer> rowQueue =new ArrayDeque<>();
        Queue<Integer> colQueue =new ArrayDeque<>();
        rowQueue.add(sr);
        colQueue.add(sc);
        int[][] visited=new int[image.length][image[0].length];
        int[][] d={{1,0},
                {-1,0},
                {0,1},
                {0,-1}};
        while (!rowQueue.isEmpty()){
            int n= rowQueue.size();
            for(int i=0;i<n;i++){
                int row=rowQueue.poll();
                int col=colQueue.poll();
                for(int j=0;j<d.length;j++){
                    int nRow=row+d[j][0];
                    int nCol=col+d[j][1];
                    if(nRow>=0&&nRow<image.length&&nCol>=0&&nCol<image[nRow].length&&visited[nRow][nCol]==0&&image[nRow][nCol]==image[row][col]){
                        visited[nRow][nCol]=1;
                        rowQueue.add(nRow);
                        colQueue.add(nCol);
                    }
                }
                image[row][col]=color;
            }
        }
        return image;
    }
}
