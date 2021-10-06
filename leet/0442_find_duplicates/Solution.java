// LeetCode 442. Find All Duplicates in an Array
// https://leetcode.com/problems/find-all-duplicates-in-an-array/
// O(n) time, O(1) space
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<Integer>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                duplicates.add(Math.abs(num));
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        return duplicates;
    }
}
