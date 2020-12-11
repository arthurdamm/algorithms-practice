// LeetCode 80. Remove Duplicates from Sorted Array II
// O(n) time O(1) space
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                int k = j + 1;
                while (k < nums.length && nums[k] == nums[j])
                    k++;
                j = k - 1;
            }
            nums[++i] = nums[j++];
        }
        return i + 1;
    }
}
