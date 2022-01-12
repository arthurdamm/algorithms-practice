// LeetCode 701. Insert into a Binary Search Tree
// https://leetcode.com/problems/insert-into-a-binary-search-tree/
// O(h) time, O(1) space
class Solution {
public:
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        TreeNode *node = root, *newNode = new TreeNode(val), *prev = NULL;
        while (node) {
            prev = node;
            if (node->val < val)
                node = node->right;
            else
                node = node->left;
        }
        if (!prev)
            return newNode;
        else if (prev->val < val)
            prev->right = newNode;
        else
            prev->left = newNode;
        return root;
    }
};

// LeetCode 701. Insert into a Binary Search Tree
// https://leetcode.com/problems/insert-into-a-binary-search-tree/
// O(h) time, O(h) space
class Solution {
public:
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        if (!root)
            return new TreeNode(val);
        if (val > root->val)
            root->right = insertIntoBST(root->right, val);
        else
            root->left = insertIntoBST(root->left, val);
        return root;
    }
};
