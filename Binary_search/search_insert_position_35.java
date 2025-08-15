package Strivers_dsa.Binary_search;

public class search_insert_position_35 {
    public static int searchInsert(int[] nums, int target) {
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
        mid=left;
        return mid;
    }
    public static void main(String[]args){
        int[] nums={1,3,5,6};
        int target=2;
        System.out.println(searchInsert(nums,target));
    }
}
