package Strivers_dsa;
import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        boolean check=true;
        for(int i=0;i<m/2+1;i++){
            for(int j=i;j<n-i;j++){
                result.add(matrix[i][j]);
                check=false;
            }
            if(check)
                break;
            check=true;
            for(int j=i+1;j<m-i;j++){
                result.add(matrix[j][n-1-i]);
                check=false;
            }
            if(check)
                break;
            check=true;
            for(int j=n-i-2;j>=i;j--){
                result.add(matrix[m-1-i][j]);
                check=false;
            }
            if(check)
                break;
            check=true;
            for(int j=m-i-2;j>i;j--){
                result.add(matrix[j][i]);
                check=false;
            }
            if(check)
                break;
            check=true;
        }
        return result;
    }
    public static void main(String[]args){
        int[][] matrix =  {
                {42}
        };
        System.out.println(spiralOrder(matrix));
    }
}
