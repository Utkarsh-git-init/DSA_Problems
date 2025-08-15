package Strivers_dsa.Array;

import javax.swing.*;
import java.util.ArrayList;

public class Rearrange_array_element_by_sign_2149 {
    public int[] rearrangeArray(int[] nums) {
        int res[]=new int[nums.length];
        for(int i=0,j=0,k=1;i<nums.length;i++){
             if(nums[i]>0){
                 res[j]=nums[i];
                 j+=2;
             }
             else{
                 res[k]=nums[i];
                 k+=2;
             }
        }
        return res;
    }
}

//
/*
ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg =new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                pos.add(nums[i]);
            else
                neg.add(nums[i]);
        }
        for(int i=0,count1=0,count2=0;i<nums.length;i++){
            if(i%2!=0)
                nums[i]=neg.get(count1++);
            else
                nums[i]=pos.get(count2++);
        }
        return nums;
 */