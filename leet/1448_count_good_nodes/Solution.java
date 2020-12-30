// LeetCode 1448. Count Good Nodes in Binary Tree
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
// O(n) time, O(1) space
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    
    int dfs(TreeNode root, int max) {
        if (root == null)
            return 0;
        int ret = root.val >= max ? 1 : 0;
        max = Math.max(max, root.val);
        ret += dfs(root.left, max);
        ret += dfs(root.right, max);
        return ret;
    }
}
