package com.overflowing;

import java.util.Arrays;

public class Solution486 {
    public static boolean PredictTheWinner(int[] nums) {
        int[] scores = new int[nums.length];
        int turn = 1;
        if(nums.length%2==0){
            for(int i=0; i<nums.length; i++)
                scores[i] = -nums[i];
        }
        else {
            turn = -1;
            System.arraycopy(nums, 0, scores, 0, nums.length);
        }
        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<nums.length-i; j++) {
                int score1 = scores[j] + nums[i+j] * turn;
                int score2 = scores[j+1] + nums[j] * turn;
                if(turn * score1 > turn * score2)
                    scores[j] = score1;
                else
                    scores[j] = score2;
            }
            turn *= -1;
        }
        return scores[0] >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,100,3,9};
        System.out.println(Solution486.PredictTheWinner(nums));
    }
}
