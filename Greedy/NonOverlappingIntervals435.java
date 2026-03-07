package Strivers_dsa.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        ArrayList<int[]> list=new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(list.getLast()[1]<=intervals[i][0]){
                list.add(intervals[i]);
            }else{
                if(list.getLast()[1]>intervals[i][1]){
                    list.removeLast();
                    list.add(intervals[i]);
                }
            }
        }
        return intervals.length-list.size();
    }
}
