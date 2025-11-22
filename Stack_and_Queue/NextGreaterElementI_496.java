package Strivers_dsa.Stack_and_Queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class NextGreaterElementI_496 {
    public int[] monotonicStack(int []nums){
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            if(stack.isEmpty()){
                res[i]=-1;
                stack.push(nums[i]);
                continue;
            }
            if(stack.peek()>nums[i]){
                res[i]=stack.peek();
                stack.push(nums[i]);
            }else{
                while(!stack.isEmpty()&&stack.peek()<=nums[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i]=-1;
                    stack.push(nums[i]);
                }else{
                    res[i]=stack.peek();
                    stack.push(nums[i]);
                }
            }
        }
        return res;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            hmap.put(nums2[i],i);
        }
        int []nextGreaterElementArray=monotonicStack(nums2);
        int res[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i]=nextGreaterElementArray[hmap.get(nums1[i])];
        }
        return res;
    }

    static void main() {
        NextGreaterElementI_496 obj=new NextGreaterElementI_496();
        int []nums1={2,4};
        int []nums2={1,2,3,4};
        int []res= obj.nextGreaterElement(nums1,nums2);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
