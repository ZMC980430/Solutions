package com.overflowing;

import java.util.*;

public class Main{

    // 32进制加法 用0-9和a-z表示
    public static String add(String a, String b){
        ArrayList<Integer> aList = new ArrayList<>();
        int carry = 0;
        for(int i=0; i<a.length() && i<b.length(); i++){
            int ai = getNum(a.charAt(a.length() - 1 - i));
            int bi = getNum(b.charAt(b.length() - 1 - i));
            int sum = ai + bi + carry;
            carry = sum / 36;
            aList.add(sum % 36);
        }
        if(a.length() > b.length()){
            carry = getRetail(b, a, aList, carry);
        }
        else if(a.length() < b.length()){
            carry = getRetail(a, b, aList, carry);
        }
        if(carry != 0)
            aList.add(carry);
        StringBuilder sb = new StringBuilder();
        for(int i=aList.size() - 1; i>=0; i--){
            sb.append(getChar(aList.get(i)));
        }
        return sb.toString();
    }

    private static int getRetail(String a, String b, ArrayList<Integer> aList, int carry) {
        for(int i=a.length(); i<b.length(); i++){
            int bi = getNum(b.charAt(b.length() - 1 - i));
            int sum = bi + carry;
            carry = sum / 36;
            aList.add(sum % 36);
        }
        return carry;
    }

    public static int getNum(char c){
        if(c >= '0' && c <= '9')
            return c - '0';
        else
            return c - 'a' + 10;
    }

    public static char getChar(int num){
        if(num >= 0 && num <= 9)
            return (char)(num + '0');
        else
            return (char)(num - 10 + 'a');
    }

    //输入数组和数组长度，以及一个目标值，找到数组中和为目标值的两个数字的个数
    static int solve(int[] arr, int n, int m){
        Arrays.sort(arr);
        int count = 0;
        int left = 0, right = n - 1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == m)
                count++;
            if(sum < m)
                left++;
            else
                right--;
        }
        return count;
    }

    public static boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(0))
                if(s1.substring(i).equals(s2.substring(s1.length()-i, s1.length()))&&s1.substring(i, s1.length()).equals(s2.substring(s1.length()-i)))
                    return true;
        }
        return false;
    }

    public static String solveEquation(String equation) {
        int coefficient = 0;
        int constant = 0;
        int sign = 1;
        int operator = 1;
        int number = 0;
        boolean normal = true;
        for(char c: equation.toCharArray()) {
            if(c == '=') {
                constant += sign*operator*number;
                sign = -1;
                operator = 1;
                number = 0;
                normal = true;
            }
            if(c<='9' && c>='0') {
                number = number*10 + c-'0';
                normal = false;
            }
            if(c == 'x') {
                if(number == 0 && normal) number = 1;
                coefficient += sign*operator*number;
                number = 0;
                normal = true;
            }
            if(c == '-') {
                constant += sign*operator*number;
                operator = -1;
                number = 0;
                normal = true;
            }
            if(c == '+') {
                constant += sign*operator*number;
                operator = 1;
                number = 0;
                normal = true;
            }
        }
        constant += sign*operator*number;
        if(coefficient == 0) {
            if(constant == 0) return "Infinite solutions";
            return "No solution";
        }

        return "x=" + Integer.toString(-constant/coefficient);
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, Integer> indices = new HashMap<>();
        for(int i=0; i<groupSizes.length; i++) {
            if(indices.containsKey(groupSizes[i])){
               List<Integer> curr =  results.get(indices.get(groupSizes[i]));
               curr.add(i);
               if(curr.size() == groupSizes[i]) {
                   indices.remove(groupSizes[i]);
               }
            }
            else {
                indices.put(groupSizes[i], results.size());
                List<Integer> curr = new ArrayList<>();
                curr.add(i);
                results.add(curr);
                if(curr.size() == groupSizes[i]) {
                    indices.remove(groupSizes[i]);
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
//        int[] arr = {1,19,18,3,5,4,16};
//        System.out.println(solve(arr, 7, 20));
//        int[] group = {1, 1, 3, 3, 3, 2, 1, 2};
//        System.out.println(Main.groupThePeople(group));
        System.out.println(-6%4);

    }
}
