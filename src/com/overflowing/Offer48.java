package com.overflowing;

import java.util.HashMap;
import java.util.Map;

public class Offer48 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l=0, max=0;
        for(int i=0; i<s.length(); i++) {
            char c=s.charAt(i);

            if(map.containsKey(c)) {
                int index=map.get(c);
                if(i-index<=l) {
                    l=i-index-1;
                }
            }
            map.put(c, i);
            l++;
            if(l>max) max = l;
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(Offer48.lengthOfLongestSubstring(
                "abcabcbb"));
    }
}
