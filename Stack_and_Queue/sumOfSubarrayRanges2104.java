package Strivers_dsa.Stack_and_Queue;

import java.util.Arrays;
import java.util.Stack;

public class sumOfSubarrayRanges2104 {
    public static long subArrayRanges(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int[] nextSmaller=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            nextSmaller[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        int[] nextGreater=new int[nums.length];
        stack.removeAllElements();
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty()&&nums[stack.peek()]<=nums[i])
                stack.pop();
            nextGreater[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        long[] arr=new long[nums.length];
        Arrays.fill(arr,1);
        long maxSum=0;
        for(int i=0;i<nums.length;i++){
            if(nextGreater[i]==-1){
                maxSum+=arr[i]*(nums.length-i)*nums[i];
            }else{
                maxSum+=arr[i]*(nextGreater[i]-i)*nums[i];
                arr[nextGreater[i]]+=arr[i];
            }
        }
        long minSum=0;
        Arrays.fill(arr,1);
        for(int i=0;i<nums.length;i++){
            if(nextSmaller[i]!=-1){
                minSum+=arr[i]*(nextSmaller[i]-i)*nums[i];
                arr[nextSmaller[i]]+=arr[i];
            }else
                minSum+=arr[i]*(nums.length-i)*nums[i];
        }
        return maxSum-minSum;
    }
    public static void main(String[] args){
        int arr[]={1,2,3};
        subArrayRanges(arr);
    }
}
