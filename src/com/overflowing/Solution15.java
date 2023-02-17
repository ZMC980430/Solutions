package com.overflowing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int left=0, right=nums.length-1;
        List<List<Integer>> results = new ArrayList<>();
        while(nums[right]>=0 && left<right) {
            int sum = nums[left] + nums[right];
            if(-sum>nums[right]) {
                left++;
                while(left<nums.length && nums[left]==nums[left-1]) left++;
                continue;
            }
            for(int i=left; i<right && nums[i]<=0; i++) {
                if(i>0&&nums[i-1]==nums[i]) {
                    continue;
                }
                sum = nums[i] + nums[right];
                int index = Arrays.binarySearch(nums, i+1, right, -sum);
                if(index>0) {
                    results.add(Arrays.asList(nums[i], nums[index], nums[right]));
                }
            }
            right--;
            while(right>0 && nums[right]==nums[right+1]) right--;
        }
        return results;
    }

    public static void main(String[] args) {
        Solution15 s = new Solution15();
        int[] nums = {0, 0, 0, 0, 0};
        for(List<Integer> l: s.threeSum(nums)) {
            System.out.println(l.toString());
        }
    }
}
