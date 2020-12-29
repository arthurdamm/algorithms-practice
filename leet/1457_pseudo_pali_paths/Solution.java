// LeetCode 1457. Pseudo-Palindromic Paths in a Binary Tree
// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
// O(n) time O(1) space
class Solution {
    int counts = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        return backtrack(root);
    }
    
    int backtrack(TreeNode root) {
        if (root == null)
            return 0;
        int ret = 0;
        counts ^= 1 << root.val;
        if (root.left == null && root.right == null) {
            if ((counts & (counts - 1)) == 0)
                ret = 1;
        } else {
            ret = backtrack(root.left) + backtrack(root.right);
        }
        counts ^= 1 << root.val;
        return ret;
    }
}
