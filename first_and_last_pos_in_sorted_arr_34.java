package Strivers_dsa;

import java.util.Arrays;

public class first_and_last_pos_in_sorted_arr_34 {
    public static int[] searchRange(int[] nums, int target) {
        int left=0,right=nums.length-1,mid=0;
        int[] res=new int[2];
        Arrays.fill(res,-1);
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target){
                res[0]=mid;
                right=mid-1;
            }
            else if(nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        left=0;
        right=nums.length-1;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target){
                res[1]=mid;
                left=mid+1;
            }
            else if(nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return res;
    }
    public static void main(String[]args){
        int []arr={5,7,7,8,8,10};
        int target=8;
        int[] res=searchRange(arr,target);
        System.out.println(res[0]+" "+res[1]);
    }
}
