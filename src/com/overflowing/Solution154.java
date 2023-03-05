package com.overflowing;

/**
已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
        若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
        若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
        注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。

        给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。

        你必须尽可能减少整个过程的操作步骤。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

public class Solution154 {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length-1);
    }

    public int find(int[] nums, int l, int r) {
        if(l==r) return nums[l];
        if((r-l)==1) return Math.min(nums[l], nums[r]);
        int mid = (l+r)/2;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(nums[mid]<=nums[l])
            left = find(nums, l, mid);
        if(nums[mid]>=nums[r])
            right = find(nums, mid, r);
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        Solution154 solution154 = new Solution154();
        int[] nums = new int[] { 2,2,2,3,3,2};
        System.out.println(solution154.findMin(nums));
    }
}
