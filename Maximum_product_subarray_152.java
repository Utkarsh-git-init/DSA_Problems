package Strivers_dsa;

public class Maximum_product_subarray_152 {
    public static int maxProduct(int[] nums) {
        int prefix=1,suffix=1;
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            if(prefix==0)
                prefix=1;
            if(suffix==0)
                suffix=1;
            suffix*=nums[nums.length-i-1];
            prefix*=nums[i];
            max=Math.max(prefix,max);
            max=Math.max(suffix,max);
        }
        return max;
    }
    public static void main(String[]args){
        int[]arr={2, -1, 3, -2, 4, 0, -4, 6, -5, 0, 2, -1, 3, -2, 4, -3, 5, -4, 6};
        System.out.println(maxProduct(arr));
    }
}

// failed
/*
    public static int maxProduct(int[] nums) {
        int max =nums[0],product=nums[0];
        int temp3 =1;
        if(nums[0]<0)
            temp3=nums[0];
        int temp2=1,temp1=1;
        for(int i=1;i<nums.length;i++){
            if(product==0){
                product=nums[i];
                temp3=nums[i]<0?nums[i]:1;
                temp2=1;temp1=1;
                continue;
            }
            if(nums[i]==0){
                max=Math.max(max,product);
                max=Math.max(max,0);

            }
            max=Math.max(max,product);
            product*=nums[i];
            if(nums[i]<0){
                temp1=temp2;
                temp2=temp3;
                temp3=product;
                max=Math.max(max,product/temp1);
                //System.out.println("temp3=="+temp3+" temp1=="+temp1+"  temp2=="+temp2);
            }
        }
        if(product>0)
            max=Math.max(max,product);
        else{
            max=Math.max(max,product/temp1);
            max=Math.max(max,product/temp2);
            if(temp3!=product)
                max=Math.max(max,product/temp3);
        }

        return max;
    }
 */