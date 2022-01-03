// LeetCode 997. Find the Town Judge
// https://leetcode.com/problems/find-the-town-judge/
// O(n) time-and-space
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        if (trust.size() < n - 1)
            return -1;
        int nToTrust[n + 1];
        memset(nToTrust, 0, sizeof(nToTrust));
        for (vector<int>& t : trust) {
            nToTrust[t[0]]--;
            nToTrust[t[1]]++;
        }
        for (int i = 1; i <= n; i++)
            if (nToTrust[i] == n - 1)
                return i;
        return -1;
    }
};
