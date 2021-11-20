// LeetCode 540. Single Element in a Sorted Array
// https://leetcode.com/problems/single-element-in-a-sorted-array/
// O(logn) time, O(1) space
function singleNonDuplicate(nums: number[]): number {
    let lo = 0, hi = nums.length;
    while (lo < hi) {
        const mid = Math.floor(lo + (hi - lo) / 2);
        if (mid > 0 && nums[mid - 1] === nums[mid]) {
            if (mid % 2 === 0) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        } else if (mid < nums.length - 1 && nums[mid + 1] == nums[mid]) {
            if ((mid - 1) % 2 === 0) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        } else
            return nums[mid];
    }
    return -1;
};
