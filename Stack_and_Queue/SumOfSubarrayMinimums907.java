package Strivers_dsa.Stack_and_Queue;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayMinimums907 {
    public static int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int[] nextSmaller=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(i);
                nextSmaller[i]=-1;
            }else {
                if(arr[stack.peek()]<arr[i]){
                    nextSmaller[i]=stack.peek();
                    stack.push(i);
                }else{
                    while(!stack.isEmpty()&&arr[stack.peek()]>arr[i])
                        stack.pop();
                    if(stack.isEmpty()){
                        stack.push(i);
                        nextSmaller[i]=-1;
                    }else {
                        nextSmaller[i]=stack.peek();
                        stack.push(i);
                    }
                }
            }
        }
        int[] arr2=new int[arr.length];
        Arrays.fill(arr2, 1);
        long sum=0;
        for(int i=0;i<arr.length;i++){
            long ai=arr[i];
            //System.out.println("arr2=="+arr2[i]);
            if(nextSmaller[i]==-1){
                sum+=(((ai%1000000007)*(arr.length-i)%1000000007)*arr2[i])%1000000007;
            }else{
                sum+=(((ai%1000000007)*(nextSmaller[i]-i)%1000000007)*arr2[i])%1000000007;
                arr2[nextSmaller[i]]+=arr2[i];
            }
            sum=sum%1000000007;
            //System.out.println("sum=="+sum);
        }
        return (int)sum;
    }
    public static void main(String[] args) {
        int[] arr={3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }
}
