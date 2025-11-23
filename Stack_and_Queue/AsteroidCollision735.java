package Strivers_dsa.Stack_and_Queue;

import java.util.Stack;
//positive meaning right, negative meaning left
public class AsteroidCollision735 {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(stack.isEmpty()){
                stack.push(asteroids[i]);
                continue;
            }
            if(asteroids[i]*stack.peek()<0){
                if(stack.peek()<0)
                    stack.push(asteroids[i]);
                else{
                    int x=-1;
                    while(!stack.isEmpty()&&stack.peek()>0){
                        if(stack.peek()==(asteroids[i]*-1)){
                            x=0;
                            stack.pop();
                            break;
                        }else if(stack.peek()<(asteroids[i]*-1)){
                            x=1;
                            stack.pop();
                        }else{
                            x=2;
                            break;
                        }
                    }
                    if(x!=0&&(stack.isEmpty()||x==1)){
                        stack.push(asteroids[i]);
                    }
                }
            }else{
                stack.push(asteroids[i]);
            }
        }
        int[] res=new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            res[i]=stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[]={1,-1,-2,-2};
        asteroidCollision(arr);
    }
}
