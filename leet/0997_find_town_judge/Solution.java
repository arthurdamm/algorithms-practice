// LeetCode 997. Find the Town Judge
// https://leetcode.com/problems/find-the-town-judge/
// O(n) time-and-space
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        for (var trustuple : trust) {
            inDegrees[trustuple[0]]--;
            inDegrees[trustuple[1]]++;
        }
        for (int i = 1; i < inDegrees.length; i++)
            if (inDegrees[i] == n - 1)
                return i;
        return -1;
    }
}
