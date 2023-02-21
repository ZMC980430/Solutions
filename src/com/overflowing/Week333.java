package com.overflowing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week333 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[][] result = new int[nums1.length+nums2.length][2];
        int flg1=0, flg2=0;
        int flg=0;
        while(flg1< nums1.length && flg2 < nums2.length) {
            if(nums1[flg1][0] < nums2[flg2][0]) {
                result[flg] = nums1[flg1++];
            }
            else if(nums1[flg1][0] > nums2[flg2][0]) {
                result[flg] = nums2[flg2++];
            }
            else {
                result[flg][0] = nums1[flg1][0];
                result[flg][1] = nums1[flg1++][1] + nums2[flg2++][1];
            }
            flg++;
        }

        if(flg1<nums1.length) {
            for(; flg1<nums1.length; flg1++)
                result[flg++]=nums1[flg1];
        }
        if(flg2<nums2.length) {
            for(; flg2<nums2.length; flg2++)
                result[flg++]=nums2[flg2];
        }
        return Arrays.copyOfRange(result, 0, flg);
    }

    public int minOperations(int n) {
        int result=0;
        int flg=0;
        while(n>0) {
            int pos = n%2;
            if(pos==0) {
                if(flg>1) {
                    result++;
                    flg=1;
                }
                else if(flg==1) {
                    result++;
                    flg=0;
                }
            }
            else {
                flg++;
            }
            n=n>>1;

        }
        if(flg>1)
            return result+2;
        return result+1;
    }

    public int squareFreeSubsets(int[] nums) {
        int MOD = 1000000007;
        int[] count = new int[31];
        int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 19};
        for(int n: nums) {
            count[n] += 1;
        }
        count[4]=0; count[9]=0; count[16]=0; count[25]=0;
        int result=1;
        for(int c: count);
        return 0;
    }

    public static void main(String[] args) {
        Week333 week333 = new Week333();
        int n=55;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(week333.minOperations(n));
    }
}
