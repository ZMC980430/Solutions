package com.overflowing;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int result=Integer.MAX_VALUE;
        int sum=0;
        while(left<right-1) {
            int remain = target - nums[left] - nums[right];
            int idx = search(nums, left, right, remain);
            if(idx>=0) return target;
            if(Math.abs(remain-nums[-idx])<result){
                result = Math.abs(remain-nums[-idx]);
                sum = nums[left] + nums[right] + nums[-idx];
            }
            right--;
        }
        return sum;
    }

    public int search(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        if(low==toIndex) low-=1;
        if(low-1<=fromIndex) return -low;
        if(Math.abs(key-a[low])>Math.abs(key-a[low-1])) return -low+1;
        return -low;
    }

    public static void main(String[] args) {
        Solution16 s = new Solution16();
        System.out.println(s.threeSumClosest(new int[]{-1,2,1,-4}, 1));

    }
}
