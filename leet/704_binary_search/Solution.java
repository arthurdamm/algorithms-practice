// LeetCode 704. Binary Search
// O(logn) time, O(1) space
class Solution {
    public int search(int[] nums, int target) {
        // int i = Arrays.binarySearch(nums, target);
        int lo = 0, hi = nums.length - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else if (nums[mid] > target)
                hi = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}

