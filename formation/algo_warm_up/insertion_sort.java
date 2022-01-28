// LeetCode 912. Sort an Array
// https://leetcode.com/problems/sort-an-array/
// O(n^2) time, O(1) space INSERTION SORT
class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i], j = i - 1;
            for (; j >= 0 && nums[j] > num; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = num;
        }
        return nums;
    }
}
