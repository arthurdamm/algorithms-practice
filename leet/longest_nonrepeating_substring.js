#!/usr/bin/env node
/** LeetCode 3 Longest Substring Without Repeating Characters
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let max = 0, seen = {}, start = 0, i;
    if (!s.length) return 0;
    for (i = 0; i < s.length; i++) {
        if (seen[s[i]] != undefined) {
            max = Math.max(max, i - start);
            start = Math.max(start, seen[s[i]] + 1);
        }
        seen[s[i]] = i;
    }
    return Math.max(max, i - start);
};

s = "b";
console.log("Solution", s, lengthOfLongestSubstring(s));
s = "baba";
console.log("Solution", s, lengthOfLongestSubstring(s));
s = "abba";
console.log("Solution", s, lengthOfLongestSubstring(s));
s = "abcabcbb";
console.log("Solution", s, lengthOfLongestSubstring(s));
s = "dvdf";
console.log("Solution", s, lengthOfLongestSubstring(s));
