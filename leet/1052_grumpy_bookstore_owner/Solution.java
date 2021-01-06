// LeetCode 1052. Grumpy Bookstore Owner
// https://leetcode.com/problems/grumpy-bookstore-owner/
// O(n) time, O(1) space
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max = 0, gain = 0, happy = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1)
                gain += customers[i];
            else
                happy += customers[i];
            if (i >= X && grumpy[i - X] == 1)
                gain -= customers[i - X];
            max = Math.max(gain, max);
        }
        return max + happy;
    }
}
