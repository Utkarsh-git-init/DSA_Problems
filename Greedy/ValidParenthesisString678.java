package Strivers_dsa.Greedy;

public class ValidParenthesisString678 {
    public boolean checkValidString(String s) {
        int countLeftP=0,countStar=0;
        int countRightStar=0; // try to understand this alone after basic code this stores the number of stars after '(' that are left after full traversal;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            switch (c){
                case '(':
                    countLeftP++;
                    break;
                case ')':
                    if(countLeftP>0) {
                        countLeftP--;
                        if(countRightStar>0&&countRightStar>countLeftP)
                            countRightStar--;
                    }
                    else if(countStar>0) {
                        if(countStar>countRightStar)
                            countStar--;
                        else {
                            countStar--;
                            countRightStar--;
                        }
                    }
                    else
                        return false;
                    break;
                case '*':
                    if(countLeftP>0&&countRightStar<countLeftP)
                        countRightStar++;
                    countStar++;
                    break;
            }
        }
        if(countLeftP>countRightStar)
            return false;
        return true;
    }

    static void main() {
        ValidParenthesisString678 obj=new ValidParenthesisString678();
        String testcase1="*****((*(((((****";
        System.out.println(obj.checkValidString("*****((*(((((****"));
    }
}
/*
Strivers solution
public boolean checkValidString(String s) {
        int min=0,max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }
            else if(s.charAt(i)==')'){
                if(min!=0)
                    min--;
                max--;
            }
            else{
                if(min==0)
                    min--;
                max++;
            }
            if(max==-1)
                return false;
        }
        return min == 0;
    }
 */