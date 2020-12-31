// LeetCode 1423. Maximum Points You Can Obtain from Cards
// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
// O(k) time, O(1) space
class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int sum = accumulate(cardPoints.begin(), cardPoints.begin() + k, 0);
        if (k >= cardPoints.size())
            return sum;
        int maxsum = sum;
        for (int i = 0; i < k; i++) {
            sum = sum - cardPoints[k - i - 1]  + cardPoints[cardPoints.size() - i - 1];
            maxsum = max(maxsum, sum);
        }
        return maxsum;
    }
};
