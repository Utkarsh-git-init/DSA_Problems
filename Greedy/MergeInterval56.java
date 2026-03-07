package Strivers_dsa.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeInterval56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> list=new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=list.getLast()[1]){
                int start=list.getLast()[0];
                int end=Math.max(intervals[i][1],list.getLast()[1]);
                list.removeLast();
                list.add(new int[]{start,end});
            }else{
                list.add(intervals[i]);
            }
        }
        int[][] res=new int[list.size()][];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }

    static void main() {
        int[][] intervals={{4,7},{1,5},{1,4}};
        MergeInterval56 obj=new MergeInterval56();
        obj.merge(intervals);
    }
}
