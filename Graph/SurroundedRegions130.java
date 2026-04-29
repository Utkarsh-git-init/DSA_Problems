package Strivers_dsa.Graph;

public class SurroundedRegions130 {
    public void solve(char[][] board) {
        int[][] visited = new int[board.length][board[0].length];
        int[][] d = {{1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}};

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O' && visited[0][j] == 0)
                dfs(0, j, board, visited,d);
            if (board[board.length - 1][j] == 'O' && visited[board.length - 1][j] == 0)
                dfs(board.length - 1, j, board, visited,d);
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O' && visited[i][0] == 0)
                dfs(i, 0, board, visited,d);
            if (board[i][board[0].length - 1] == 'O' && visited[i][board[0].length-1] == 0)
                dfs(i, board[0].length - 1, board, visited,d);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='O'&&visited[i][j]==0)
                    board[i][j]='X';
            }
        }
    }

    private void dfs(int i, int j, char[][] board, int[][] visited, int[][] d) {
        visited[i][j]=1;
        for (int[] ints : d) {
            int ni = i + ints[0];
            int nj = j + ints[1];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[ni].length && board[ni][nj] == 'O' && visited[ni][nj] == 0)
                dfs(ni, nj, board, visited, d);
        }
    }
}
