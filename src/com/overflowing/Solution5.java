package com.overflowing;

public class Solution5 {
    public String longestPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int result = 0;
        String sub = "";
        for(int i=0; i<s.length(); i++) {
            for(int j=0; j+i<s.length(); j++) {
                if(i==0) isPalindrome[j][j] = true;
                else {
                    boolean b = s.charAt(j) == s.charAt(i + j);
                    if(i==1) isPalindrome[j][i+j] = b;
                    else isPalindrome[j][i+j] = b && isPalindrome[j+1][i+j-1];
                }
                if(isPalindrome[j][i+j] && i+1>result) {
                    sub = s.substring(j, i+j+1);
                    result = i+1;
                }
            }
        }
        return sub;
    }

    public static void main(String[] args) {
        String s = "aabba";
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome(s));
    }
}
