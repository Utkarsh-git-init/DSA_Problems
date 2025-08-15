package Strivers_dsa.Array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Longest_consecutive_sequence_128 {
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        HashMap<Integer,Integer> hmap=new HashMap<>();
        int max=1;
        for(int i:nums)
            hmap.put(i,1);
        for(int i:hmap.keySet()){
            if(!hmap.containsKey(i-1)){
                int count=1;
                int temp=i;
                while(hmap.containsKey(temp+1)){
                    count++;
                    temp++;
                }
                if(count>max)
                    max=count;
            }
        }
        return max;
    }
    public static void main(String[]args){
        int []nums={-3, -2, -1, -4};
        System.out.println(longestConsecutive(nums));
    }
}


//
/*if(nums.length==0)
            return 0;
        HashMap<Integer,Integer> hmap=new HashMap<>();
        int max=1;
        for(int i:nums)
            hmap.put(i,1);

        for(int i:hmap.keySet()){
            int count=1;
            int temp1=i,temp2=i;
            while(hmap.containsKey(temp1-1)){
                count++;
                temp1--;
            }
            while(hmap.containsKey(temp2+1)){
                count++;
                temp2++;
            }
            if(count>max)
                max=count;
        }
        return max;

 */

// using iterator only removes current element
/*
if(nums.length==0)
            return 0;
        HashMap<Integer,Integer> hmap=new HashMap<>();
        int max=1;
        for(int i:nums)
            hmap.put(i,1);
        Iterator<HashMap.Entry<Integer,Integer>> iterator=hmap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> entry=iterator.next();
            int count=1;
            int temp1=entry.getKey(),temp2= entry.getKey();
            while(hmap.containsKey(temp1-1)){
                count++;
                temp1--;
            }
            while(hmap.containsKey(temp2+1)){
                count++;
                temp2++;
            }
            if(count>max)
                max=count;
            iterator.remove();
        }
        return max;
 */