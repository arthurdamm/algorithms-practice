// LeetCode 1094. Car Pooling
// https://leetcode.com/problems/car-pooling/
// O(nlogn) time, O(n) space
class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        vector<int*> events;
        for (auto trip : trips) {
            events.push_back(new int[2]{trip[1], trip[0]});
            events.push_back(new int[2]{trip[2], -trip[0]});
        }
        sort(events.begin(), events.end(), [](auto &a, auto &b) {
            return a[0] == b[0] ? a[1] < b[1] : a[0] < b[0];
        });
        for (auto event : events) {
            if ((capacity -= event[1]) < 0)
                return false;
        }
        return true;
    }
};
