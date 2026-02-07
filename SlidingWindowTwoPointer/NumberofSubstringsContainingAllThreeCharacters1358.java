package Strivers_dsa.SlidingWindowTwoPointer;

public class NumberofSubstringsContainingAllThreeCharacters1358 {
    public static int numberOfSubstrings(String s) {
        int itr1=0,itr2=0;
        int a=0,b=0,c=0;
        int res=0;
        while(itr2<s.length()){
            switch (s.charAt(itr2)){
                case 'a':a++;break;
                case 'b':b++;break;
                case 'c':c++;break;
            }
            if(a!=0&&b!=0&&c!=0){
                res+=(s.length()-itr2);
                System.out.println(res);
                while(a!=0&&b!=0&&c!=0){
                    switch (s.charAt(itr1)){
                        case 'a':a--;break;
                        case 'b':b--;break;
                        case 'c':c--;break;
                    }
                    res+=s.length()-itr2;
                    itr1++;
                }
                res-=s.length()-itr2;
                System.out.println("itr2="+itr2);
                System.out.println("itr1"+itr1);
                System.out.println(res);
            }
            itr2++;
        }
        return res;
    }

    static void main() {
        System.out.println(numberOfSubstrings("bcabac"));
    }
}
