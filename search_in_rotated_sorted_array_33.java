package Strivers_dsa;

public class search_in_rotated_sorted_array_33 {
    public static int search(int[] nums, int target) {
        int n=nums.length;
        int k=0;
        int left=0,right=n-1,mid;
        if(nums[0]>nums[n-1]){
            while(left<=right){
                mid=left+(right-left)/2;
                if(nums[mid]>=nums[0]){
                    left=mid+1;
                }
                else{
                    k=mid;
                    right=mid-1;
                }
            }
            if(target<=nums[n-1]){
                left=k;right=n-1;
            }
            else{
                left=0;right=k-1;
            }
        }
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
    public static void main(String[]args){
        int [] nums={8,2};
        System.out.println(search(nums,8));
    }
}
