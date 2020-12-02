// LeetCode 104. Maximum Depth of Binary Tree
// O(n) time, O(logn) space

class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    
    int dfs(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
