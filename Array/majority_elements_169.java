package Strivers_dsa.Array;

public class majority_elements_169 {
    public int majorityElement(int[] nums) {
        int element=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(count==0)
                element=nums[i];
            if(nums[i]==element)
                count++;
            else
                count--;
        }
        return element;
    }
}
