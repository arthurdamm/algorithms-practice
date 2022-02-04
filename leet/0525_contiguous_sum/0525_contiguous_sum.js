// LeetCode 525. Contiguous Array
// https://leetcode.com/problems/contiguous-array/
// O(n) time-and-space
var findMaxLength = function(nums) {
    const hash = {0: -1};
    let prefixSum = 0, maxLen = 0;
    for (let i = 0; i < nums.length; i++) {
        prefixSum += 2 * nums[i] - 1;
        if (prefixSum in hash) {
            maxLen = Math.max(maxLen, i - hash[prefixSum])
        } else {
            hash[prefixSum] = i;
        }
    }
    return maxLen;
};
