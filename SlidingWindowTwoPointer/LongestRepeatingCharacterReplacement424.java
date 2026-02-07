package Strivers_dsa.SlidingWindowTwoPointer;


public class LongestRepeatingCharacterReplacement424 {
    public static int characterReplacement(String s, int k) {
        int[] letterCount=new int[26];
        for(int i=0;i<26;i++){
            letterCount[i]=0;
        }
        int itr1=0,itr2=0,res=0,replaceCount=0;
        char maxChar=s.charAt(0);
        while(itr2<s.length()){
            letterCount[s.charAt(itr2)-'A']++;
            if(letterCount[s.charAt(itr2)-'A']>letterCount[maxChar-'A'])
                maxChar=s.charAt(itr2);
            replaceCount=itr2-itr1+1-letterCount[maxChar-'A'];
            while(itr1<s.length()&&replaceCount>k){
                res=Math.max(res,itr2-itr1);
                letterCount[s.charAt(itr1)-'A']--;
                for(int i=0;i<26;i++){
                    if(letterCount[i]>letterCount[maxChar-'A'])
                        maxChar=(char)(i+'A');
                }
                itr1++;
                replaceCount=itr2-itr1+1-letterCount[maxChar-'A'];
            }
            itr2++;
        }
        res=Math.max(res,itr2-itr1);
        return res;
    }
    static void main() {
        System.out.println(characterReplacement("BAAAB",2));
    }
}
