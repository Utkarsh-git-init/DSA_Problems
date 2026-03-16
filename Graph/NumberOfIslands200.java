package Strivers_dsa.Graph;

public class NumberOfIslands200 {
    int recursion(char[][] grid,int[][] visited,int prevRow,int prevCol,int row,int col){
        if(row>=grid.length||row<0||col<0||col>=grid[0].length)
            return 0;
        if(grid[row][col]=='0'||visited[row][col]==1)
            return 0;
        int temp1,temp2,temp3;
        visited[row][col]=1;
        if(prevCol==col){
            if(row+1==prevRow){ // we moved up in the last recursion level
                temp1=recursion(grid,visited,row,col,row-1,col);//up
                temp2=recursion(grid,visited,row,col,row,col-1);//left
                temp3=recursion(grid,visited,row,col,row,col+1);//right
            }else{ // we moved down in the last recursion level
                temp1=recursion(grid,visited,row,col,row+1,col);//down
                temp2=recursion(grid,visited,row,col,row,col-1);//left
                temp3=recursion(grid,visited,row,col,row,col+1);//right
            }
        }else if(col+1==prevCol){ // we moved left in the previous recursion level
            temp1=recursion(grid,visited,row,col,row+1,col);//down
            temp2=recursion(grid,visited,row,col,row-1,col);//up
            temp3=recursion(grid,visited,row,col,row,col-1);//left
        }else{ // we moved right in the last recursion level
            temp1=recursion(grid,visited,row,col,row+1,col);//down
            temp2=recursion(grid,visited,row,col,row-1,col);//up
            temp3=recursion(grid,visited,row,col,row,col+1);//right
        }
        return temp1+temp2+temp3+1;
    }
    public int numIslands(char[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                visited[i][j]=0;
            }
        }
        int count=0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==0&&grid[i][j]=='1') {
                    recursion(grid, visited, i - 1, j, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
/*

public class NumberOfIslands200 {
    public int numIslands(char[][] grid) {
        HashMap<Integer,Integer> islands=new HashMap<>();
        int[] arr=new int[grid[0].length];
        int count=0;//for making island keys
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='0'){
                    arr[j]=-1;
                }else{
                    int leftIsland =-1, aboveIsland =-1;
                    if(j-1>=0&&grid[i][j-1]=='1')
                        leftIsland =arr[j-1]; // string key of island just left
                    if(i-1>=0&&grid[i-1][j]=='1')
                        aboveIsland =arr[j]; // storing key of island just above

                    if(leftIsland !=-1&& aboveIsland !=-1){
                        if(leftIsland == aboveIsland) {
                            arr[j] = aboveIsland;
                            islands.put(leftIsland,islands.get(leftIsland)+1);
                        }
                        else{
                            islands.put(aboveIsland,islands.get(aboveIsland)+islands.get(leftIsland)+1);
                            islands.remove(leftIsland);
                            arr[j]= aboveIsland;
                            for(int k=0;k<=j;k++){
                                if(arr[k]==leftIsland)
                                    arr[k]=aboveIsland;
                            }
                        }
                    }else if(leftIsland !=-1){
                        islands.put(leftIsland,islands.get(leftIsland)+1);
                        arr[j]= leftIsland;
                    }else if(aboveIsland !=-1){
                        islands.put(aboveIsland,islands.get(aboveIsland)+1);
                        arr[j]= aboveIsland;
                    }else{
                        count++;
                        islands.put(count,1);
                        arr[j]=count;
                    }
                }
            }
        }
        return islands.size();
    }
}

fails on

[["1","1","1","1","1","0","1","1","1","1"],["0","1","1","0","1","1","1","0","1","1"],["1","0","1","0","1","1","0","1","0","1"],["1","0","1","1","0","1","1","1","1","1"],["1","1","0","0","1","1","1","1","1","1"],["1","1","0","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","0","1"],["0","1","1","0","1","1","1","1","1","0"],["1","1","0","1","1","0","1","1","1","1"],["0","1","1","1","1","1","0","1","1","1"]][["1","1","1","1","1","0","1","1","1","1"],["0","1","1","0","1","1","1","0","1","1"],["1","0","1","0","1","1","0","1","0","1"],["1","0","1","1","0","1","1","1","1","1"],["1","1","0","0","1","1","1","1","1","1"],["1","1","0","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","0","1"],["0","1","1","0","1","1","1","1","1","0"],["1","1","0","1","1","0","1","1","1","1"],["0","1","1","1","1","1","0","1","1","1"]]
 */