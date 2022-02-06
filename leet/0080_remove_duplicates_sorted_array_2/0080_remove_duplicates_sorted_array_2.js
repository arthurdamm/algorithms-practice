// LeetCode 80. Remove Duplicates from Sorted Array II
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// O(n) time, O(1) space
var removeDuplicates = function(nums) {
    let i = 0;
    for (num of nums)
        if (i < 2 || num != nums[i - 2])
            nums[i++] = num;
    return i;
};
