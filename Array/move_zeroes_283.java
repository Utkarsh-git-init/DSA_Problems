package Strivers_dsa.Array;

public class move_zeroes_283 {
    public void moveZeroes(int[] nums) {
        for(int i=0,j=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
                if(i!=j)
                    nums[i]=0;
            }
        }
    }
}
