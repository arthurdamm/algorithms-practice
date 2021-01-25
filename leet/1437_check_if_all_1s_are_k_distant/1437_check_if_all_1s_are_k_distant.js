// LeetCode 1437. Check If All 1's Are at Least Length K Places Away
// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
// O(n) time, O(1) space
var kLengthApart = function(nums, k) {
    let prev = -k - 1;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] == 1) {
            if (i - prev <= k)
                return false;
            prev = i;
        }
    }
    return true;
};
