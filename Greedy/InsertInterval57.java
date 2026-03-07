package Strivers_dsa.Greedy;

import java.util.ArrayList;

public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list=new ArrayList<>();
        boolean check=true;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]<newInterval[0]){
                list.add(intervals[i]);
            }else{
                int start=0,end=0;
                start = Math.min(intervals[i][0], newInterval[0]);
                while(i<intervals.length&&intervals[i][1]<=newInterval[1])
                    i++;
                if(i==intervals.length){
                    end=newInterval[1];
                    list.add(new int[]{start,end});
                    check=false;
                    break;
                }
                if(intervals[i][0]<=newInterval[1]) {
                    end = intervals[i][1];
                    i++;
                }
                else
                    end=newInterval[1];
                list.add(new int[]{start,end});
                while (i<intervals.length)
                    list.add(intervals[i++]);
                check=false;
            }
        }
        if(check)
            list.add(newInterval);
        int[][] res=new int[list.size()][];
        for(int i=0;i< list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
