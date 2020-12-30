// LeetCode 1448. Count Good Nodes in Binary Tree
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
// O(n) time, O(1) space
class Solution {
public:
    int goodNodes(TreeNode* root) {
        return dfs(root, INT_MIN);
    }
    
    int dfs(TreeNode* root, int _max) {
        if (!root)
            return 0;
        int ret = root->val >= _max ? 1 : 0;
        _max = max(_max, root->val);
        ret += dfs(root->left, _max);
        ret += dfs(root->right, _max);
        return ret;
    }
};
