package Strivers_dsa.Strings;

public class rotate_string_796 {
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
            return false;
        boolean res=true;
        for(int i=0;i<s.length();i++){
            res=false;
            if(s.charAt(i)==goal.charAt(0)){
                res=true;
                for(int j=0,k=i;j<goal.length();j++,k++){
                    if(k==goal.length())
                        k=0;
                    if(s.charAt(k)!=goal.charAt(j)){
                        res=false;
                        break;
                    }
                }
            }
            if(res)
                break;
        }
        return res;
    }
    public static void main(String[]args){
        String s="";
        String goal="";
        System.out.println(rotateString(s,goal));
    }
}
