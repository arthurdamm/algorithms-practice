// LeetCode 110. Balanced Binary Tree
// O(n) time, O(h) space
class Solution {
    boolean balanced = true;
    
    public boolean isBalanced(TreeNode root) {
        height(root);
        return balanced;
    }
    
    int height(TreeNode root) {
        if (root == null)
            return 0;
        int left = height(root.left), right = height(root.right);
        if (Math.abs(left - right) > 1)
            balanced = false;
        return Math.max(left, right) + 1;
    }
}
