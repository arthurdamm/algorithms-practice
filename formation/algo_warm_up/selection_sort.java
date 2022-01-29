// LeetCode 912. Sort an Array
// https://leetcode.com/problems/sort-an-array/
// O(n^2) time, O(1) space SELECTION SORT
class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i])
                    min = j;
            }
            if (i != min) {
                nums[i] ^= nums[min];
                nums[min] ^= nums[i];
                nums[i] ^= nums[min];
            }            
        }
        return nums;
    }
}
