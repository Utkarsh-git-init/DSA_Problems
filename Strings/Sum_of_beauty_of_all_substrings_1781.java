package Strivers_dsa.Strings;

import java.util.HashMap;

public class Sum_of_beauty_of_all_substrings_1781 {
    //beats 20% in runtime
    public int beautySum(String s) {
        HashMap<Character,Integer> hmap=new HashMap<>();
        int res=0;
        for(int i=0;i<s.length();i++){
            int max=1,min=1;
            hmap.clear();
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                hmap.put(ch,hmap.getOrDefault(ch,0)+1);
                max=Math.max(hmap.get(ch),max);
                if(hmap.get(ch)<min){
                    min=hmap.get(ch);
                }else if(!hmap.containsValue(min))
                    min++;
                res+=max-min;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s="aab";
        Sum_of_beauty_of_all_substrings_1781 instance =new Sum_of_beauty_of_all_substrings_1781();
        System.out.println(instance.beautySum(s));
    }
}
