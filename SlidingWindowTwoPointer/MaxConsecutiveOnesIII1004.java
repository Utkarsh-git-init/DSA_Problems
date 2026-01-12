package Strivers_dsa.SlidingWindowTwoPointer;

public class MaxConsecutiveOnesIII1004 {
    public static int longestOnes(int[] nums, int k) {
        int ptr1=0,ptr2=0,zeroCount=0,res=0;
        while(ptr2<nums.length){
            if(nums[ptr2]==0){
                if(zeroCount<k){
                    zeroCount++;
                }else{
                    res=Math.max(res,ptr2-ptr1);
                    while(nums[ptr1]!=0)
                        ptr1++;
                    ptr1++;
                }
            }
            ptr2++;
        }
        res=Math.max(res,ptr2-ptr1);
        return res;
    }

    static void main() {
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(nums,k));
    }
}
