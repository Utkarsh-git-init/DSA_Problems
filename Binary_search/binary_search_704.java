package Strivers_dsa.Binary_search;

public class binary_search_704 {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1,mid;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }
}
