package Strivers_dsa.Strings;

import java.util.HashMap;

public class sort_characters_by_freq_451 {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hmap=new HashMap<>();
        String res;
        for(int i=0;i<s.length();i++){
            hmap.put(s.charAt(i),hmap.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=s.length();i>0;){
            if(hmap.containsValue(i)){

                i=s.length()-i;
            }
            else
                i--;
        }
        return null;
    }
}
