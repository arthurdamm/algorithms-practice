// LeetCode 84. Largest Rectangle in Histogram
// https://leetcode.com/problems/largest-rectangle-in-histogram/
// O(n) time O(n) space
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<size_t> istack;
        stack<int> hstack;
        int _max = 0;
        heights.push_back(0);
        for (size_t i = 0; i < heights.size(); i++) {
            size_t prev = ULONG_MAX;
            while (!hstack.empty() && hstack.top() > heights[i]) {
                prev = istack.top();
                _max = max(_max, hstack.top() * (int)(i - prev));
                istack.pop();
                hstack.pop();
            }
            if (hstack.empty() || hstack.top() < heights[i]) {
                istack.push(min(prev, i));
                hstack.push(heights[i]);
            }
        }
        return _max;
    }
};
