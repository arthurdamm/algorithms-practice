// LeetCode 1318. Minimum Flips to Make a OR b Equal to c
// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
// O(n) time O(1) space
class Solution {
    public int minFlips(int a, int b, int c) {
        int dist = 0;
        for (int i = 0; a + b + c != 0; a >>= 1, b >>= 1, c >>= 1)
            if ((c & 1) == 0)
                dist += (a & 1) + (b & 1);
            else if ((a & 1) + (b & 1) == 0)
                dist++;
        return dist;
    }
}
