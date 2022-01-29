// LeetCode 912. Sort an Array
// https://leetcode.com/problems/sort-an-array/
// O(n^2) time, O(1) space BUBBLE SORT
class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    nums[j] ^= nums[j - 1];
                    nums[j - 1] ^= nums[j];
                    nums[j] ^= nums[j - 1];
                }
            }
        }
        return nums;
    }
}
