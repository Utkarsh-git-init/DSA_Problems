package Strivers_dsa.Greedy;

import java.util.Arrays;

public class AssignCookies455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        for (int i=g.length-1,j=s.length-1;i>=0&&j>=0;){
            if(s[j]>=g[i]){
                count++;
                j--;
                i--;
            }else{
                i--;
            }
        }
        return count;
    }
}
/*
public int findContentChildren(int[] g, int[] s) {
        PriorityQueue<Integer> gHeap=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> sHeap=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i:g)
            gHeap.add(i);
        for(int i:s)
            sHeap.add(i);
        int count=0;
        while(!gHeap.isEmpty()&&!sHeap.isEmpty()){
            if(gHeap.peek()<=sHeap.peek()){
                count++;
                gHeap.poll();
                sHeap.poll();
            }else{
                gHeap.poll();
            }
        }
        return count;
    }
 */