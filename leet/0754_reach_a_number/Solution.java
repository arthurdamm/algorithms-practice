// LeetCode 754. Reach a Number
// https://leetcode.com/problems/reach-a-number/
// O(1) time O(1) space
class Solution {
    public int reachNumber(int target) {
        int s = 0, n = 0;
        target = Math.abs(target);
        n = (int)Math.ceil((-1 + Math.sqrt(1 + 8 * (long)target)) / 2);
        s = n * (n + 1) / 2;
        if ((s - target) % 2 == 0)
            return n;
        return n + ((s + n + 1 - target) % 2 == 0 ? 1 : 2);
    }
}

// O(root(n)) time O(1) space
class Solution {
    public int reachNumber(int target) {
        int s = 0, n = 0;
        target = Math.abs(target);
        while (s < target)
            s += ++n;
        if ((s - target) % 2 == 0)
            return n;
        return n + ((s + n + 1 - target) % 2 == 0 ? 1 : 2);
    }
}
