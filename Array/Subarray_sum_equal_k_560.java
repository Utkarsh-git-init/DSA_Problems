package Strivers_dsa.Array;

import java.util.*;

public class Subarray_sum_equal_k_560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hmap=new HashMap<>();
        hmap.put(0,1);
        int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hmap.containsKey(sum-k))
                count+=hmap.get(sum-k);
            hmap.put(sum,hmap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
