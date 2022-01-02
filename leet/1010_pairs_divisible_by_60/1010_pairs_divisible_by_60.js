// LeetCode 1010. Pairs of Songs With Total Durations Divisible by 60
// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
// O(n) time, O(1) space
var numPairsDivisibleBy60 = function(time) {
    const modToCount = Array(60).fill(0);
    let pairs = 0;
    for (let t of time) {
        t %= 60;
        modToCount[t]++;
        if (t !== 0 && t !== 30)
            pairs += modToCount[60 - t];
    }
    pairs += modToCount[0] * (modToCount[0] - 1) / 2;
    pairs += modToCount[30] * (modToCount[30] - 1) / 2;
    return pairs;
};
