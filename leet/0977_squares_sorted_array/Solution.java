// LeetCode 977. Squares of a Sorted Array
// O(n) time O(n) space
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ret = new int[nums.length];
        int i = 0, j = nums.length - 1, k = j;
        
        while (i <= j)
            if (Math.abs(nums[i]) > nums[j])
                ret[k--] = nums[i] * nums[i++];
            else
                ret[k--] = nums[j] * nums[j--];
        return ret;
    }
}

