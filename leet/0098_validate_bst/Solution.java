// LeetCode 98. Validate Binary Search Tree
// O(n) time O(h) space
class Solution { 
    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root, null, null);
    }

    public boolean _isValidBST(TreeNode root, Integer min, Integer max) {
        return root == null || ((min == null || root.val > min)
            && (max == null || root.val < max))
            && _isValidBST(root.left, min, root.val)
            && _isValidBST(root.right, root.val, max);
    }
}

