package Strivers_dsa.Stack_and_Queue;

import java.util.Stack;

public class NextGreaterElementII_503 {
    public static int[] nextGreaterElements(int[] nums) {
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
        for(int i=nums.length-1;i>=0;i--){
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

    static void main() {
        int arr[]={1,2,3,4,5,6,5,4,5,1,2,3};
        int res[]=nextGreaterElements(arr);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
