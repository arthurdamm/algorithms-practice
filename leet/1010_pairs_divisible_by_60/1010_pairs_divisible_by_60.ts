// LeetCode 1010. Pairs of Songs With Total Durations Divisible by 60
// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
// O(n) time, O(1) space
function numPairsDivisibleBy60(time: number[]): number {
    const modToCount = Array(60).fill(0);
    for (let t of time) modToCount[t % 60]++;
    let pairs = modToCount[0] * (modToCount[0] - 1) / 2;
    pairs += modToCount[30] * (modToCount[30] - 1) / 2;
    for (let t = 1; t < 30; t++)
        pairs += modToCount[t] * modToCount[60 - t];
    return pairs;
};

