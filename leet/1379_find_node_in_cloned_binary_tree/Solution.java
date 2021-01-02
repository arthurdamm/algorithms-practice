// LeetCode 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
// O(n) time, O(h) space
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null)
            return null;
        if (original == target)
            return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null)
            return left;
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if (right != null)
            return right;
        return null;
    }
}
