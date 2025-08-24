package Strivers_dsa.Strings;

public class Max_Nesting_Depth_of_Parentheses_1614 {
    public int maxDepth(String s) {
        int count=0,max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
                max=count>max?count:max;
            }
            else if(s.charAt(i)==')')
                count--;
            if(count<0)
                count=0;
        }
        return max;
    }
}
