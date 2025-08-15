package Strivers_dsa;

public class max_consecutive_ones_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                if(count>max)
                    max=count;
            }
            else count=0;
        }
        return max;
    }
}