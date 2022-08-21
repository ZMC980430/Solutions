package com.overflowing;

public class Subseq {
    public static int findLUSlength(String[] strs) {
        int ans = -1;
        label1:
        for(int i=0; i<strs.length; i++) {
            if(strs[i].length()<ans) continue;
            for(int j=0; j<strs.length; j++) {
                if(i==j) continue;
                if(strs[i].length() > strs[j].length()) continue;
                if(isSubseq(strs[i], strs[j])) continue label1;
            }
            ans = strs[i].length();
        }
        return ans;
    }
    public static boolean isSubseq(String a, String b) {
        if(a.length() > b.length()) return false;
        int flga = 0, flgb = 0;
        while(flgb<b.length()) {
            if(a.charAt(flga) == b.charAt(flgb))
                flga++;
            flgb++;
            if(flga == a.length())
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String a = "aaa";
        String b = "aaa";
        String[] s = {a, b};
        System.out.println(findLUSlength(s));
    }
}
