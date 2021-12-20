// LeetCode 1200. Minimum Absolute Difference
// https://leetcode.com/problems/minimum-absolute-difference/
// O(nlogn) time, O(n) space
class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        vector<vector<int>> ret;
        sort(arr.begin(), arr.end());
        int minDiff = INT_MAX;
        for (int i = 1; i < arr.size(); i++) {
            minDiff = min(minDiff, arr[i] - arr[i - 1]);
        }
        for (int i = 1; i < arr.size(); i++) {
            if (arr[i] - arr[i - 1] == minDiff)
                ret.push_back({arr[i - 1], arr[i]});
        }
        return ret;
        
    }
};
