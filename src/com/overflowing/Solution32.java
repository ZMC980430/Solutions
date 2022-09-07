package com.overflowing;

import util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses(String s) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(' ', 0));
        for(char c: s.toCharArray()) {
            if(c=='(')
                stack.add(new Pair<>(c, 0));
            else if(c==')') {
                if(stack.peek().key.equals('(')) {
                    Pair<Character, Integer> curr = stack.pop();
                    stack.peek().value+=(curr.value+2);
                }
                else
                    stack.push(new Pair<>(')', 0));
            }
        }
        int result=0;
        while(!stack.isEmpty()) {
            Pair<Character, Integer> curr = stack.pop();
            if(curr.value>result)
                result = curr.value;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = ")()())()()(";
        System.out.println(new Solution32().longestValidParentheses(s));
    }
}
