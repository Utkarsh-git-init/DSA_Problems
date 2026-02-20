package Strivers_dsa.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class HandOfStraights846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(groupSize==1)
            return true;
        if(hand.length%groupSize!=0)
            return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:hand)
            map.put(i,map.getOrDefault(i,0)+1);
        ArrayList<Integer> list=new ArrayList<>(map.keySet());
        list.sort(Comparator.comparingInt(i -> i));
        int i=0,j=1;
        if(list.size()<groupSize)
            return false;
        while(j<list.size()){
            while(j<list.size()&&j-i+1<=groupSize){
                int cur=list.get(j);
                int pre=list.get(j-1);
                if((cur==pre+1)&&(map.get(cur)>=map.get(pre))){
                    map.put(cur,(map.get(cur)-map.get(list.get(i))));
                    j++;
                }else{
                    return false;
                }
            }
            if(j-i==groupSize){
                int freq=map.get(list.get(i));
                map.put(list.get(i),0);
                while(i<j&&map.get(list.get(i))==freq) {
                    i++;
                }
                j = i + 1;
                if(i==list.size())
                    return true;
                if(list.size()-i<groupSize)
                    return false;
            }else
                return false;
        }
        return true;
    }

    static void main() {
        int[] hand={8,8,9,7,7,7,6,7,10,6};
        int groupSize=2;
        HandOfStraights846 obj=new HandOfStraights846();
        System.out.println(obj.isNStraightHand(hand,groupSize));
    }
}
/*
int[] hand={1,2,3,6,2,3,4,7,8};
        int groupSize=3;

        int[] hand={1,1,2,2,3,3};
        int groupSize=2;
 */