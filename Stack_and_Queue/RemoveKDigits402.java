package Strivers_dsa.Stack_and_Queue;

import java.util.Stack;

public class RemoveKDigits402 {
    public static String removeKdigits(String num, int k) {
        Stack<Integer> stack=new Stack<>();
        StringBuilder res=new StringBuilder(num);
        for(int i=0;i<res.length()&&k>0;i++){
            int n=res.charAt(i)-'0';
            int j=i-1;
            while(!stack.isEmpty()&&stack.peek()>n&&k>0){
                stack.pop();
                res.deleteCharAt(j--);
                i--;
                k--;
            }
            stack.push(n);
        }
        if(k>0){
            while(k>0){
                res.deleteCharAt(res.length()-1);
                k--;
            }
        }
        while(!res.isEmpty()&&res.charAt(0)=='0'){
            res.deleteCharAt(0);
        }
        if(res.isEmpty())
            return "0";
        return res.toString();
    }
    public static void main(String[] args) {
        String num="10200";
        System.out.println(removeKdigits(num,1));
        System.out.println();
    }
}
