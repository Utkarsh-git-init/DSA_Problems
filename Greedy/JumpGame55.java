package Strivers_dsa.Greedy;

public class JumpGame55 {
    public boolean canJump(int[] nums) {
        int itr1=0,itr2=0;
        while(itr2<nums.length-1){
            if(itr1>itr2)
                return false;
            if(itr2<itr1+nums[itr1])
                itr2=itr1+nums[itr1];
            itr1++;
        }
        return true;
    }
}
