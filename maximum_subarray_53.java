package Strivers_dsa;

public class maximum_subarray_53 {
    public static int maxSubArray(int[] nums) {
        int max=nums[0],sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>max)
                max=sum;
            if(sum<0)
                sum=0;
        }
        return max;
    }
    public static void main(String[]args){
        int nums[]={1,2,-1};
        System.out.println(maxSubArray(nums));
    }
}


// 1st
/*if(nums.length==1)
            return nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
        int res=nums[0];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(res<(nums[j]-nums[i]))
                    res=nums[j]-nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(res<nums[i])
                res=nums[i];
        }
        return res;*/