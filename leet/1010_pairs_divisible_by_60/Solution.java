// LeetCode 1010. Pairs of Songs With Total Durations Divisible by 60
// O(n) time O(1) space
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        for (int t : time)
            count[t % 60]++;
        int pairs = count[0] * (count[0] - 1) / 2;
        pairs += count[30] * (count[30] - 1) / 2;
        for (int i = 1; i < 30; i++)
            pairs += count[i] * count[60 - i];
        return pairs;
    }
}
