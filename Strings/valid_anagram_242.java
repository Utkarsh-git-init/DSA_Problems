package Strivers_dsa.Strings;

import java.util.HashMap;

public class valid_anagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Integer> hmap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(hmap.containsKey(ch)){
                hmap.put(ch,hmap.get(ch)-1);
                if(hmap.get(ch)<0)
                    return false;
            }
            else
                return false;
        }
        return true;
    }
}
