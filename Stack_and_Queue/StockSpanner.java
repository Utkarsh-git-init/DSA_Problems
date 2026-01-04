package Strivers_dsa.Stack_and_Queue;

import java.util.Stack;

public class StockSpanner {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int i=0;
    public StockSpanner() {
        stack1 =new Stack<>();
        stack2 =new Stack<>();
    }
    public int next(int price) {
        int res=1;
        while(!stack1.isEmpty()&& stack1.peek()<=price){
            stack2.pop();
            stack1.pop();
        }
        ++i;
        if(!stack2.isEmpty())
            res=i-stack2.peek();
        else
            res=i;
        stack1.push(price);
        stack2.push(i);
        return res;
    }
}
/*
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */