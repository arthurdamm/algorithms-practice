// LeetCode 1217. Minimum Cost to Move Chips to The Same Position
// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
// O(n) time, O(1) space
class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int chip: position) {
            if (chip % 2 == 0)
                even++;
            else
                odd++;
        }
        return Math.min(odd, even);
    }
}

