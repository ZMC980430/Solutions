package com.overflowing;

import java.util.ArrayList;
import java.util.List;

public class Solution8 {
    public static int myAtoi(String s) {
        int flg=0;
        int sign = 1;
        while(flg<s.length() && s.charAt(flg)==' ') flg++;
        if(flg>=s.length()) return 0;
        else if(s.charAt(flg)=='-') {
            sign=-1;
            flg++;
        }
        else if(s.charAt(flg)=='+')
            flg++;
        List<Integer> number = new ArrayList<>();
        for(;flg<s.length(); flg++) {
            int n = s.charAt(flg) - '0';
            if(n>=0 && n<10)
                number.add(n);
            else
                break;
        }
        for(int i=0; i<number.size(); i++) {
            if(number.get(i)!=0) {
                number = number.subList(i, number.size());
                break;
            }
            if(i==number.size()-1 && number.get(i)==0)
                number.clear();
        }
        if(number.isEmpty()) return 0;
        if(number.size()>10) {
            if(sign>0) return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }
        long result = 0;
        for(int i=0; i<number.size(); i++) {
            long sub = (long) (sign * Math.pow(10, i) * number.get(number.size()-1-i));
            result += sub;
            if(result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(result<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        String s = "  0000000000000   ";
        System.out.println(Solution8.myAtoi(s));
    }
}
