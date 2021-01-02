// LeetCode 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
// O(n) time, O(h) space
class Solution {
public:
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
        if (original == NULL)
            return NULL;
        if (original == target)
            return cloned;
        TreeNode *left = getTargetCopy(original->left, cloned->left, target);
        if (left)
            return left;
        TreeNode *right = getTargetCopy(original->right, cloned->right, target);
        if (right)
            return right;
        return NULL;
    }
};
