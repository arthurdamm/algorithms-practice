// LeetCode 1026. Maximum Difference Between Node and Ancestor
// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
// O(n) time-and-space
class Solution {
public:
    int maxAncestorDiff(TreeNode* root) {
        return compareMinMax(root, root->val, root->val);
    }
    
    int compareMinMax(TreeNode *root, int minVal, int maxVal) {
        if (!root)
            return maxVal - minVal;
        return max(compareMinMax(root->left, min(minVal, root->val), max(maxVal, root->val)),
                   compareMinMax(root->right, min(minVal, root->val), max(maxVal, root->val)));
    }
};
