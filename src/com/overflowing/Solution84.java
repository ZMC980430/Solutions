package com.overflowing;

import java.util.LinkedList;
import java.util.Stack;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int[] lSquare = new int[heights.length];
        int[] rSquare = new int[heights.length];
        Stack<Integer> lStack = new Stack<>();
        Stack<Integer> rStack = new Stack<>();
        int lStart = 0, rStart = heights.length - 1;
        for(int i=0; i<heights.length; i++){
            visit(heights, lSquare, lStack, i);
            int j = heights.length - i -1;
            visit(heights, rSquare, rStack, j);
        }
        int max = 0;
        for(int i=0; i<heights.length; i++) {
            int square = heights[i] * (lSquare[i]+rSquare[i]-1);
            if(square>max)
                max = square;
        }
        return max;
    }

    public void visit(int[] heights, int[] square, Stack<Integer> stack, int j) {
        if(stack.isEmpty() || heights[stack.peek()]<heights[j]) {
            stack.push(j);
            square[j] = 1;
        }
        else {
            int currSquare=1;
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[j]) {
                currSquare += square[stack.pop()];
            }
            stack.push(j);
            square[j] = currSquare;
        }
    }

    public static void main(String[] args) {
        int[] height = {3,3,3,3};
        Solution84 s = new Solution84();
        System.out.println(s.largestRectangleArea(height));
    }
}
