// LeetCode 442. Find All Duplicates in an Array
// https://leetcode.com/problems/find-all-duplicates-in-an-array/
// O(n) time, O(1) space
function findDuplicates(nums: number[]): number[] {
    const duplicates = [];
    nums.forEach(num => {
        if(nums[Math.abs(num) - 1] < 0) {
            duplicates.push(Math.abs(num));
        } else {
            nums[Math.abs(num) - 1] *= -1;
        }
    });
    return duplicates;
};
