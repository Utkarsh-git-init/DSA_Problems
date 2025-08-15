package Strivers_dsa.Binary_search;

public class Find_Min_in_Rotated_Sorted_Array_153 {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(nums[0]>nums[n-1]){
            int left=0;
            int right=n-1,mid,res=-1;
            while(left<=right){
                mid=left+(right-left)/2;
                if(nums[mid]>=nums[0])
                    left=mid+1;
                else {
                    res=nums[mid];
                    right = mid - 1;
                }
            }
            return res;
        }
        else
            return nums[0];
    }
}
