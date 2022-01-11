// LeetCode 1022. Sum of Root To Leaf Binary Numbers
// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
// O(n) time, O(h) space
class Solution {    
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int val = sum << 1 | root.val;
        if (root.left == null && root.right == null)
            return val;
        else
            return dfs(root.left, val) + dfs(root.right, val);
    }
}
