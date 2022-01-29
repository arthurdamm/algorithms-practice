// 704. Binary Search
// https://leetcode.com/problems/binary-search/
// O(logn) time, O(1) space
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                hi = mid;
            else
                lo = mid + 1;
        }
        return -1;
    }
}
