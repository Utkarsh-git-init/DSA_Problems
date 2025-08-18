package Strivers_dsa.Strings;

public class Largest_odd_num_in_string_1903 {
    public String largestOddNumber(String num) {
        for(int i=num.length()-1;i>=0;i--){
            if((num.charAt(i)-'0')%2!=0)
                return num.substring(0,i+1);
        }
        return "";
    }
}
// 1st solution doesn't work because no known data structure can hold 10^5 length of string
/*
for(int i=0;i<num.length();i++){
            for(int j=num.length();j>i;j--){
                int n=Long.parseInt(num.substring(i,j));
                if(n%2!=0)
                    return Integer.toString(n);
            }
        }
        return "";
 */