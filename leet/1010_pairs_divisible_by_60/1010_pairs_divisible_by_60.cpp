// LeetCode 1010. Pairs of Songs With Total Durations Divisible by 60
// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
// O(n) time, O(1) space
class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        int count[60] = {0};
        for (int t : time)
            count[t % 60]++;
        int pairs = count[30] * (count[30] - 1) / 2;
        pairs += count[0] * (count[0] - 1) / 2;
        for (int t = 1; t < 30; t++)
            pairs += count[t] * count[60 - t];
        return pairs;
    }
};
