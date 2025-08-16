package Strivers_dsa.Strings;

import java.sql.SQLOutput;

public class Reverse_words_in_string_151 {
    public static String reverseWords(String s) {
        StringBuilder words=new StringBuilder();
        StringBuilder res=new StringBuilder();
        s+=" ";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!=' '){
                words.append(ch);
            }
            else if(!words.isEmpty()){
                res.insert(0,words);
                res.insert(0,' ');
                words.setLength(0);
            }
        }
        res.deleteCharAt(0);
        return res.toString();
    }
    public static void main(String[]args){
        String s="          end    of  the world        ";
        System.out.println(reverseWords(s));
    }
}
