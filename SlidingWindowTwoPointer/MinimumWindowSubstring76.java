package Strivers_dsa.SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.Objects;

public class MinimumWindowSubstring76 {
    public static String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        int itr1 = 0, itr2 = 0, check = 0;
        StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> smap = new HashMap<>();
        while (itr2 < s.length()) {
            if (tmap.containsKey(s.charAt(itr2)))
                break;
            itr2++;
        }
        itr1 = itr2;
        while (itr2 < s.length()) {
            if (tmap.containsKey(s.charAt(itr2))) {
                smap.put(s.charAt(itr2), smap.getOrDefault(s.charAt(itr2), 0) + 1);
                if (Objects.equals(smap.get(s.charAt(itr2)), tmap.get(s.charAt(itr2))))
                    check++;
                if (check == tmap.size()) {
                    break;
                }
            }
            itr2++;
        }
        if (itr2 == s.length() && check != tmap.size())
            return "";
        res.append(s, itr1, itr2 + 1);
        while (itr1 < s.length()) {
            if (tmap.containsKey(s.charAt(itr1))) {
                smap.put(s.charAt(itr1), smap.get(s.charAt(itr1)) - 1);
                if (smap.get(s.charAt(itr1)) < tmap.get(s.charAt(itr1))) {
                    check--;
                    itr2++;
                    if (smap.get(s.charAt(itr1)) == 0)
                        smap.remove(s.charAt(itr1));
                    while (itr2 < s.length()) {
                        if (tmap.containsKey(s.charAt(itr2))) {
                            smap.put(s.charAt(itr2), smap.getOrDefault(s.charAt(itr2), 0) + 1);
                            if (Objects.equals(smap.get(s.charAt(itr2)), tmap.get(s.charAt(itr2)))) {
                                check++;
                                break;
                            }
                        }
                        itr2++;
                    }
                }
            }
            itr1++;
            if (check == tmap.size()) {
                if (res.length() > itr2 - itr1 +1) {
                    res.delete(0, res.length());
                    res.append(s, itr1, itr2+1);
                }
            }
        }
        return res.toString();
    }

    static void main() {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
/*
testcases
s: ADOBECODEBANC    t: ABC
"cbbacbabbabacbabbbabaacbaccccbcbcbcca","abcbcabaacccababacbabcacbc"
 */