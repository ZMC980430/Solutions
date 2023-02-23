package com.overflowing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 1));
        int index=start;
        for(int i=1; i<n; i++) {
            int m=1<<i;
            for(int j=0; j<m; j++) {
                int next = m+result.get(m-j-1);
                if(next==start) index=result.size();
                result.add(m+result.get(m-j-1));
            }
        }

        List<Integer> r =result.subList(index, result.size());
        r.addAll(result.subList(0, index));
        return r;
    }

    public static void main(String[] args) {
        Solution1238 s = new Solution1238();
        List<Integer> r = s.circularPermutation(2, 0);
        for (var v: r) {
            System.out.println(Integer.toBinaryString(v));
        }
    }
}
