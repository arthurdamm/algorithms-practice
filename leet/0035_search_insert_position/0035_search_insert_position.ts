// LeetCode 35. Search Insert Position
// https://leetcode.com/problems/search-insert-position/
// O(nlogn) time, O(1) space
function searchInsert(nums: number[], target: number): number {
    let lo = 0, hi = nums.length;
    while (lo < hi) {
        const mid = Math.floor(lo + (hi - lo) / 2);
        if (nums[mid] === target) {
            return mid;
        } else if (nums[mid] > target) {
            hi = mid;
        } else
            lo = mid + 1;
    }
    return lo;
};
