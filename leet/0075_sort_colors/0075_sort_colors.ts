// LeetCode 75. Sort Colors
// https://leetcode.com/problems/sort-colors/
// O(n) time, O(1) space
function sortColors(nums: number[]): void {
    let j = 0, k = nums.length - 1;
    for (let i = 0; i <= k;) {
        if (nums[i] == 0) {
            [nums[i], nums[j]] = [nums[j], nums[i]];
            j++;
            if (nums[i] == 0)
                j = ++i;
        } else if (nums[i] == 2) {
            [nums[i], nums[k]] = [nums[k], nums[i]];
            k--;
        } else
            i++;
    }
};
