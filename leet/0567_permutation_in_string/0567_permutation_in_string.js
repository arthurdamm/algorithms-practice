/*
LeetCode 567. Permutation in String
https://leetcode.com/problems/permutation-in-string/
O(n) time, O(1) space
Key Insight: constant sliding window problem;
two counters and two constant for O(1) success check
*/
var checkInclusion = function(s1, s2) {
    const k = s1.length;
    const s1Counter = Array(26).fill(0),
          s2Counter = Array(26).fill(0);
    let neededLetters = 0, extraLetters = 0;
    for (const c of s1) {
        s1Counter[c.charCodeAt(0) - 97]++;
        neededLetters++;
    }
    for (let i = 0; i < s2.length; i++) {
        let c = s2.charCodeAt(i) - 97;
        s2Counter[c]++;
        if (s1Counter[c]) {
            if (s1Counter[c] >= s2Counter[c])
                neededLetters--;
            else
                extraLetters++;
        } else
            extraLetters++;
        if (i >= k) {
            c = s2.charCodeAt(i - k) - 97;
            s2Counter[c]--;
            if (s1Counter[c]) {
                if (s1Counter[c] > s2Counter[c])
                    neededLetters++;
                else
                    extraLetters--;
            } else
                extraLetters--;
        }
        if (neededLetters === 0 && extraLetters === 0)
            return true;
    }
    return false;
};
