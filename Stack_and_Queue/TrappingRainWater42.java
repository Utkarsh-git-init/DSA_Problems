package Strivers_dsa.Stack_and_Queue;

import java.util.HashMap;
import java.util.Stack;

public class TrappingRainWater42 {
    
    static public int trap(int[] height) {
        int n=height.length;
        int[] prevGreaterElementAddr =new int[n];
        int[] nextGreaterElementAddr =new int[n];
        Stack<Integer> stack=new Stack<>();
        //creating nextGreatestElement array
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                nextGreaterElementAddr[i]=-1;
                stack.push(i);
                continue;
            }
            if(height[stack.peek()]>height[i]){
                nextGreaterElementAddr[i]=stack.peek();
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&height[stack.peek()]<=height[i])
                    stack.pop();
                if(stack.isEmpty()){
                    nextGreaterElementAddr[i]=-1;
                    stack.push(i);
                }else{
                    nextGreaterElementAddr[i]=stack.peek();
                    stack.push(i);
                }
            }
        }
        //creating prevGreatestElement array
        stack.removeAllElements();
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                prevGreaterElementAddr[i]=-1;
                stack.push(i);
                continue;
            }
            if(height[stack.peek()]>height[i]){
                prevGreaterElementAddr[i]=stack.peek();
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&height[stack.peek()]<=height[i])
                    stack.pop();
                if(stack.isEmpty()){
                    prevGreaterElementAddr[i]=-1;
                    stack.push(i);
                }else{
                    prevGreaterElementAddr[i]=stack.peek();
                    stack.push(i);
                }
            }
        }
        // printing next greater and prev greater element
//        for(int i:nextGreaterElementAddr){
//            if(i==-1){
//                System.out.print(i+" ");
//                continue;
//            }
//            System.out.print(height[i]+" ");
//        }
//        System.out.println();
//        for(int i:prevGreaterElementAddr){
//            if(i==-1){
//                System.out.print(i+" ");
//                continue;
//            }
//            System.out.print(height[i]+" ");
//        }
        // calculating water
        int water=0;
        HashMap<Integer,Integer> hmap=new HashMap<>();// stores calculated level till i reaches next greater element for that level
        for(int i=0;i<n;i++){
            if(nextGreaterElementAddr[i]==-1|| prevGreaterElementAddr[i]==-1)
                continue;
            if(hmap.containsKey(height[i])&&i<hmap.get(height[i]))
                continue;
            int min=Math.min(height[nextGreaterElementAddr[i]],height[prevGreaterElementAddr[i]]);
            water+=(min-height[i])*(nextGreaterElementAddr[i]-prevGreaterElementAddr[i]-1);
            hmap.put(height[i],nextGreaterElementAddr[i]);
        }
        return water;
    }
    static void main() {
        int[] height={4,2,0,3,2,5};
        trap(height);
    }
}
// test case 1= 0,1,0,2,1,0,1,3,2,1,2,1