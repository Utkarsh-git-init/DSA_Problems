package Strivers_dsa.Graph;

public class NumberOfProvinces547 {
    int provinces;
    public void dfs(int[][] isConnected,int[] visited,int i){
        for(int j=0;j<isConnected[i].length;j++){
            if(visited[j]==0&&isConnected[i][j]==1){
                visited[j]=1;
                dfs(isConnected,visited,j);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int[] visited=new int[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                visited[i]=1;
                provinces++;
                dfs(isConnected,visited,i);
            }
        }
        return provinces;
    }
}
