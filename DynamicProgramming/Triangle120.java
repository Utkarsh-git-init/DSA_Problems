package Strivers_dsa.DynamicProgramming;

import java.util.List;

public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] itr1=new int[triangle.getLast().size()];
        for(int j=0;j<triangle.getLast().size();j++)
            itr1[j]=triangle.getLast().get(j);
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                int temp1=triangle.get(i).get(j)+itr1[j];
                int temp2=triangle.get(i).get(j)+itr1[j+1];
                itr1[j]=Math.min(temp1,temp2);
            }
        }
        return itr1[0];
    }
}

/*
memoization

public class Triangle120 {
    int fun(List<List<Integer>> triangle,int i,int j,List<List<Integer>> dp,List<List<Boolean>> dpFlag){
        if(i==triangle.size())
            return 0;
        if(dpFlag.get(i).get(j)==false) {
            dp.get(i).set(j, triangle.get(i).get(j) + Math.min(fun(triangle, i + 1, j, dp, dpFlag), fun(triangle, i + 1, j + 1, dp, dpFlag)));
            dpFlag.get(i).set(j,true);
        }
        return dp.get(i).get(j);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp=new ArrayList<>();
        List<List<Boolean>> dpFlag=new ArrayList<>();
        for(int i=0;i<triangle.size();i++){
            dp.add(new ArrayList<>());
            dpFlag.add(new ArrayList<>());
            for(int j=0;j<triangle.get(i).size();j++){
                dp.get(i).add(-1);
                dpFlag.get(i).add(false);
            }
        }
        return fun(triangle,0,0,dp,dpFlag);
    }
}


//tabulation

public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] itr1=new int[triangle.getLast().size()];
        for(int j=0;j<triangle.getLast().size();j++)
            itr1[j]=triangle.getLast().get(j);
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                int temp1=triangle.get(i).get(j)+itr1[j];
                int temp2=triangle.get(i).get(j)+itr1[j+1];
                itr1[j]=Math.min(temp1,temp2);
            }
        }
        return itr1[0];
    }
}

 */