package Strivers_dsa.Array;

import java.util.HashMap;

public class Missing_numbers_268 {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+i-nums[i];
        }
        sum=sum+n;
        return sum;
    }
}

// using hashmap

//HashMap<Integer,Integer> a=new HashMap<>();
//        for(int i=0;i<nums.length;i++)
//        a.put(nums[i],i);
//        for(int i=0;i<=nums.length;i++){
//        if(!a.containsKey(i)){
//        return i;
//            }
//                    }