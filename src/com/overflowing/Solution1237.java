package com.overflowing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        int x=1, y=1000;
        while(x<=1000 && y>0) {
            while(y>0 && customfunction.f(x, y)>z) y--;
            if(customfunction.f(x, y)==z) {
                result.add(Arrays.asList(x, y));
                x++;
            }
            else {
                while(x<=1000 && customfunction.f(x, y)<z) x++;
            }
        }
        return result;
    }
}
interface CustomFunction {
    int f(int x, int y);
}