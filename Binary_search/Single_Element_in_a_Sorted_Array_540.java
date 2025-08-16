package Strivers_dsa.Binary_search;

public class Single_Element_in_a_Sorted_Array_540 {
    public static int singleNonDuplicate(int[] nums) {
        int n=nums.length,left=0,right=n-1,mid,res=-1;
        while(left<=right){
            mid=left+(right-left)/2;
            if(mid%2==0) {
                if(mid+1<n&&nums[mid+1]==nums[mid])
                    left=mid+1;
                else if(mid-1>-1&&nums[mid-1]==nums[mid])
                    right=mid-1;
                else{
                    res=nums[mid];
                    break;
                }
            }
            else{
                if(mid-1>-1&&nums[mid-1]==nums[mid])
                    left=mid+1;
                else if(mid+1<n&&nums[mid+1]==nums[mid])
                    right=mid-1;
                else{
                    res=nums[mid];
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[]args){
        int[]nums={2,3,3,4,4,5,5};
        System.out.println(singleNonDuplicate(nums));
    }
}