package Strivers_dsa.SlidingWindowTwoPointer;


import java.util.HashMap;

public class SubarraysWithKDifferentIntegers992 {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int itr1,itr2,itr3,res;
        itr1=itr2=itr3=res=0;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        while(itr3<nums.length&&hashMap.size()<k){
            hashMap.put(nums[itr3],hashMap.getOrDefault(nums[itr3],0)+1);
            itr3++;
        }
        while(itr3<nums.length){
            if(hashMap.size()==k){
                while(hashMap.size()==k){
                    hashMap.put(nums[itr2],hashMap.get(nums[itr2])-1);
                    if(hashMap.get(nums[itr2])==0)
                        break;
                    itr2++;
                }
                hashMap.put(nums[itr2],hashMap.get(nums[itr2])+1);
                res+=itr2-itr1+1;
            }
            hashMap.put(nums[itr3],hashMap.getOrDefault(nums[itr3],0)+1);
            itr3++;
            if(hashMap.size()>k){
                hashMap.remove(nums[itr2]);
                itr1=++itr2;
            }
        }
        if(hashMap.size()==k){
            while(hashMap.size()==k){
                hashMap.put(nums[itr2],hashMap.get(nums[itr2])-1);
                if(hashMap.get(nums[itr2])==0)
                    break;
                itr2++;
            }
            hashMap.put(nums[itr2],hashMap.get(nums[itr2])+1);
            res+=itr2-itr1+1;
        }
        return res;
    }
    static void main() {
        int[] nums={1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(nums,2));
    }
}
