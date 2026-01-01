package Strivers_dsa.Stack_and_Queue;

import java.util.Stack;

public class LargestRectangleInHistogram84 {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> heightStack=new Stack<>();
        Stack<Integer> widthStack=new Stack<>();
        heightStack.push(heights[0]);
        int max=0;
        widthStack.push(1);
        for(int i=1;i<heights.length;i++){
            if(heights[i]==heightStack.peek()){
                widthStack.push(widthStack.pop()+1);
            }else if(heights[i]>heightStack.peek()){
                heightStack.push(heights[i]);
                widthStack.push(1);
            }else{
                int width=0;
                while(heightStack.peek()>=heights[i]){
                    max=Math.max(max,heightStack.pop()* widthStack.peek());
                    //width=widthStack.peek();
                    if(!heightStack.isEmpty()){
                        if(heightStack.peek()<heights[i]){
                            width=widthStack.pop();
                        }else{
                            widthStack.push(widthStack.pop()+widthStack.pop());
                        }
                    }else{
                        width=widthStack.pop();
                        break;
                    }
                }
                heightStack.push(heights[i]);
                widthStack.push(width+1);
            }
        }
        while(widthStack.size()>1){
            max=Math.max(max,heightStack.pop()*widthStack.peek());
            widthStack.push(widthStack.pop()+widthStack.pop());
        }
        max=Math.max(max,heightStack.pop()*widthStack.pop());
        return max;
    }

    static void main() {
        int[] heights={2,1,2};
        System.out.println(largestRectangleArea(heights));
    }
}
