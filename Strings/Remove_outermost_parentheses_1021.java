package Strivers_dsa.Strings;

public class Remove_outermost_parentheses_1021 {
    public String removeOuterParentheses(String s) {
        int itr=0;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(itr==0){
                itr++;
                continue;
            }
            if(ch=='(')
                itr++;
            else
                itr--;
            if(itr!=0)
                res.append(ch);
        }
        return res.toString();
    }
}
