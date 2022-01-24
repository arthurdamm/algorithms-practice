// LeetCode 520. Detect Capital
// https://leetcode.com/problems/detect-capital/
// O(n) time, O(1) space
var detectCapitalUse = function(word) {
    return /(^[A-Z]+$)|(^[A-Z]?[a-z]+$)/.test(word);
};
