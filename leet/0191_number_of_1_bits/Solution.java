// LeetCode 191. Number of 1 Bits
// https://leetcode.com/problems/number-of-1-bits/
// O(logn) time, O(1) space
public class Solution {
    public int hammingWeight(int n) {
        int weight = 0;
        for (; n != 0; n >>>= 1)
            weight += n & 1;
        return weight;
    }
}
