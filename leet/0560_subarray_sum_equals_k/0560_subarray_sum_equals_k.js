/*
LeetCode 560. Subarray Sum Equals K
https://leetcode.com/problems/subarray-sum-equals-k/
O(n) time-and-space
Key Insight: Keep prefixsum, add count of prefixsum - k to result,
increment current prefixsum in counter
*/
var subarraySum = function(nums, k) {
    const prefixSumCount = {0: 1}
    prefixSum = 0;
    subarrays = 0;
    for (const n of nums) {
        prefixSum += n;
        if ((prefixSum - k) in prefixSumCount)
            subarrays += prefixSumCount[prefixSum - k];
        if (!prefixSumCount[prefixSum])
            prefixSumCount[prefixSum] = 0;
        prefixSumCount[prefixSum]++;
    }
    return subarrays;
};
