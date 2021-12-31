// LeetCode 1026. Maximum Difference Between Node and Ancestor
// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
// O(n) time-and-space
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return compareMinMax(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    private int compareMinMax(TreeNode root, int min, int max) {
        if (root == null)
            return max - min;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        return Math.max(compareMinMax(root.left, min, max),
                        compareMinMax(root.right, min, max));
    }
}
