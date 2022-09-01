package com.overflowing;

import java.util.Arrays;

public class Solution1475 {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        ans[prices.length-1] = 0;
        for(int i=prices.length-1; i>0; i--) {
            if(prices[i]<=prices[i-1]) ans[i-1]=prices[i];
            else {
                for(int j=i; j<prices.length; j++) {
                    if(ans[j]<=prices[i-1]) {
                        ans[i - 1] = ans[j];
                        break;
                    }
                }
            }
        }
        for(int i=0; i<prices.length; i++) {
            ans[i] = prices[i]-ans[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,4,5,8,8,4,1,5};
        Solution1475 s = new Solution1475();
        System.out.println(Arrays.toString(s.finalPrices(a)));
    }
}
