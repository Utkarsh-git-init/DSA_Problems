package Strivers_dsa.Greedy;

public class JumpGameII45 {
    public int jump(int[] nums) {
        int count=0,itr1=0,itr2=0,max=nums[0];
        while (itr2<nums.length-1){
            if(itr1==itr2){
                itr2=max;
                count++;
            }
            max=Math.max(max,itr1+nums[itr1]);
            itr1++;
        }
        return count;
    }
}
/*
for the first index we count 1. Then we find max in the range that we get from the first jump
when we reach the end of the range, we change the range and count 1
we will get the best jump in the range of first index for first index
for next index we jump from, we will find its best landing position after the end of range of first jump and before the end range of this jump
 */