// LeetCode 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// O(log(n)) time, O(1) space
var searchRange = function(nums, target) {
    const {lo, mid, hi} = binarySearch(nums, target);
    if (mid === -1 || nums[mid] !== target)
        return [-1, -1];
    const left = binarySearchLeft(nums, target, lo, mid);
    let right = binarySearchRight(nums, target, mid, hi);
    right = right == nums.length || nums[right] !== target ? right - 1 : right;
    return [left, right];
};

const binarySearch = function(nums, target) {
    let hi = nums.length, lo = 0, mid = -1;
    while (lo < hi) {
        mid = lo + Math.trunc((hi - lo) / 2);
        if (nums[mid] === target)
            break;
        else if (nums[mid] > target)
            hi = mid;
        else
            lo = mid + 1;
    }
    return {lo, mid, hi};
}

const binarySearchLeft = function(nums, target, lo, hi) {
    while (lo < hi) {
        let mid = lo + Math.trunc((hi - lo) / 2);
        if (nums[mid] >= target)
            hi = mid;
        else
            lo = mid + 1;
    }
    return lo;
}

const binarySearchRight = function(nums, target, lo, hi) {
    while (lo < hi) {
        let mid = lo + Math.trunc((hi - lo) / 2);
        if (nums[mid] <= target)
            lo = mid + 1;
        else
            hi = mid;
    }
    return lo;
}
