package Strivers_dsa;
import java.util.*;
public class pascal_triangle_118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pt=new ArrayList<>();
        ArrayList<Integer> temp1=new ArrayList<>();
        ArrayList<Integer> temp2=new ArrayList<>();
        temp1.add(1);
        pt.add(new ArrayList<>(temp1));
        for(int i=2;i<=numRows;i++){
            for(int j=0;j<i;j++){
                if(j==0)
                    temp2.add(1);
                else if(j==i-1)
                    temp2.add(1);
                else{
                    temp2.add(temp1.get(j-1)+temp1.get(j));
                }
            }
            pt.add(new ArrayList<>(temp2));
            temp1.clear();
            temp1.addAll(temp2);
            temp2.clear();
        }
        return pt;
    }
    public static void main(String[]args){
        System.out.println(generate(7));
    }
}
