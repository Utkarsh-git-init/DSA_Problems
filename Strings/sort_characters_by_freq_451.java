package Strivers_dsa.Strings;

import java.util.*;

public class sort_characters_by_freq_451 {
    public String frequencySort(String s) {

        // this looks clean buts other one was faster
        HashMap<Character,Integer> hmap=new HashMap<>();
        Comparator<Character> com=new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                return hmap.get(b)-hmap.get(a);
            }
        };
        for(int i=0;i<s.length();i++)
            hmap.put(s.charAt(i),hmap.getOrDefault(s.charAt(i),0)+1);
        List<Character> charlist=new ArrayList<>(hmap.keySet());
        Collections.sort(charlist,com);
        StringBuilder res=new StringBuilder();
        for(char i:charlist){
            for(int j=0;j<hmap.get(i);j++)
                res.append(i);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s="hellooo";
        sort_characters_by_freq_451 instance=new sort_characters_by_freq_451();
        System.out.println(instance.frequencySort(s));
    }
}
/*
// quicksort is overkill as there are only 62 unique characters
    public void quicksort(int[] freqarr, char[] chararr, int start, int end){
        if(start>=end)
            return;
        int i=start-1;
        int j=start;
        while(j<end){
            if(freqarr[j]< freqarr[end]){
                i++;
                int temp= freqarr[i];
                freqarr[i]= freqarr[j];
                freqarr[j]=temp;
                //same to chararr
                char temp2=chararr[i];
                chararr[i]=chararr[j];
                chararr[j]=temp2;
            }
            j++;
        }
        int temp= freqarr[i+1];
        freqarr[i+1]= freqarr[end];
        freqarr[end]=temp;
        //same to chararr
        char temp2=chararr[i+1];
        chararr[i+1]=chararr[end];
        chararr[end]=temp2;
        quicksort(freqarr,chararr,start,i);
        quicksort(freqarr,chararr,i+2,end);
    }
    public String frequencySort(String s) {
        HashMap<Character,Integer> hmap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hmap.put(s.charAt(i),hmap.getOrDefault(s.charAt(i),0)+1);
        }
        int[] freqarr=new int[hmap.size()];
        char[] chararr=new char[hmap.size()];
        int itr=0;
        for(char i: hmap.keySet()){
            chararr[itr]=i;
            freqarr[itr]=hmap.get(i);
            itr++;
        }
        quicksort(freqarr,chararr,0,freqarr.length-1);
        StringBuilder res=new StringBuilder();
        for(int i=chararr.length-1;i>=0;i--){
            for(int j=0;j<freqarr[i];j++)
                res.append(chararr[i]);
        }
        return res.toString();
    }
 */