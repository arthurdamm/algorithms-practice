// LeetCode 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/
// O(nlogn) time, O(1) space
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(),
            [](const vector<int> &a, const vector<int> &b) {
                return a[0] < b[0];
        });
        vector<int>* a = &intervals[0];
        for (int i = 1; i < intervals.size(); i++) {
            vector<int>* b = &intervals[i];
            if ((*a)[1] >= (*b)[0] && (*a)[0] <= (*b)[1]) {
                (*a)[1] = max((*a)[1], (*b)[1]);
                (*b)[0] = -1;
            } else
                a = b;
        }
        vector<vector<int>> ret;
        copy_if(intervals.begin(), intervals.end(), back_inserter(ret), [](const vector<int>& a) { return a[0] != -1;});
        return ret;
    }
};
