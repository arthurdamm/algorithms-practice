// LeetCode 1015. Smallest Integer Divisible by K
// https://leetcode.com/problems/smallest-integer-divisible-by-k/
// O(k) time, O(1) space
class Solution {
    public int smallestRepunitDivByK(int k) {
        int n = 1, i = 1;
        while (i <= k) {
            if (n % k == 0)
                return i;
            n = (n * 10 + 1) % k;
            i++;
        }
        return -1;        
    }
}
