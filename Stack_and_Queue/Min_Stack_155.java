package Strivers_dsa.Stack_and_Queue;

import java.util.Objects;
import java.util.Stack;

public class Min_Stack_155 {
    Stack<Integer> mainStack =new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    public Min_Stack_155() {
        minStack.push(Integer.MAX_VALUE);
    }
    public void push(int val) {
        mainStack.push(val);
        if(minStack.peek()>=val){
            minStack.push(val);
        }
    }
    public void pop() {
        if(Objects.equals(minStack.peek(), mainStack.peek())){
            minStack.pop();
        }
        mainStack.pop();
    }
    public int top() {
        return mainStack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
    static void main() {
        Min_Stack_155 obj=new Min_Stack_155();
        //test case 1
//        obj.push(-2);
//        obj.push(0);
//        obj.push(-3);
//        System.out.println(obj.getMin());
//        obj.pop();
//        System.out.println(obj.top());
//        System.out.println(obj.getMin());

        obj.push(127);
        obj.push(127);
        obj.push(129);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.push(129);
        System.out.println(obj.getMin());
    }
}
