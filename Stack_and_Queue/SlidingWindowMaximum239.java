package Strivers_dsa.Stack_and_Queue;

import java.util.Stack;

public class SlidingWindowMaximum239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> stack= new Stack<>();
        int[] nextGreater=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty()&&nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                nextGreater[i]=-1;
            else
                nextGreater[i]=stack.peek();
            stack.push(i);
        }
        int[] res=new int[nums.length-k+1];int itr=0;
        int left=0, max =0, right =k-1;
        while(right<nums.length) {
            if(max<left)
                max=left;
            while(nextGreater[max]<=right&&nextGreater[max]!=-1){
                max=nextGreater[max];
            }
            res[itr++]=nums[max];
            left++;right++;
        }
        return res;
    }
    static void main() {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] res=maxSlidingWindow(nums,3);
        for(int i:res)
            System.out.print(i+" ");
    }
}
