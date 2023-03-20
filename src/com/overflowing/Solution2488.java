package com.overflowing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2488 {
    public int countSubarrays(int[] nums, int k) {
        Map<Integer, List<Integer>> leftMap = new HashMap<>();
        Map<Integer, List<Integer>> rightMap = new HashMap<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == k) {
                index = i;
                break;
            }
        // search left
        for (int i = index - 1, sum = 0; i >= 0; i--) {
            if (nums[i] > k) sum++;
            else sum--;
            compute(leftMap, i, sum);
        }
        //search right
        for (int i = index + 1, sum = 0; i < nums.length; i++) {
            if (nums[i] > k) sum++;
            else sum--;
            compute(rightMap, i, sum);
        }
        int result = 1;
        for (var e : leftMap.entrySet()) {
            int l = e.getValue().size();
            if (rightMap.containsKey(-e.getKey())) {
                result += rightMap.get(-e.getKey()).size() * l;
            }
            if (rightMap.containsKey(1 - e.getKey())) {
                result += rightMap.get(1 - e.getKey()).size() * l;
            }
        }
        List<Integer> empty = new ArrayList<>();
        result += leftMap.getOrDefault(0, empty).size();
        result += leftMap.getOrDefault(1, empty).size();
        result += rightMap.getOrDefault(0, empty).size();
        result += rightMap.getOrDefault(1, empty).size();

        return result;
    }

    public void compute(Map<Integer, List<Integer>> map, int index, int sum) {
        if(map.containsKey(sum)) {
            map.get(sum).add(index);
        }
        else {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(index);
            map.put(sum, temp);
        }
    }

    public static void main(String[] args) {
        Solution2488 s = new Solution2488();
        System.out.println(s.getClass().getSimpleName());
    }

}
