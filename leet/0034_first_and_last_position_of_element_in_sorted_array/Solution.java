// LeetCode 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// O(log(n)) time, O(1) space
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] loMidHi = binarySearch(nums, target);
        int lo = loMidHi[0], mid = loMidHi[1], hi = loMidHi[2];
        if (mid == -1 || nums[mid] != target)
            return new int[]{-1, -1};
        
        int left = binarySearchLeft(nums, target, 0, mid),
            right = binarySearchRight(nums, target, mid, hi);
        right = right == nums.length || nums[right] != target ? right - 1 : lo;
        
        return new int[]{left, right};
    }
    
    private int[] binarySearch(int[] nums, int target) {
        int hi = nums.length, lo = 0, mid = -1;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                break;
            else if (nums[mid] > target)
                hi = mid;
            else
                lo = mid + 1;
        }
        return new int[]{lo, mid, hi};
    }
    
    private int binarySearchLeft(int[] nums, int target, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
    
    private int binarySearchRight(int[] nums, int target, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
}

