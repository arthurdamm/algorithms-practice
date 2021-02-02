// 669. Trim a Binary Search Tree
// https://leetcode.com/problems/trim-a-binary-search-tree/
// O(n) time, O(h) space
class Solution {
    int low, high;
    public TreeNode trimBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        return _trimBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
     
    private TreeNode _trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        if (root.val >= this.low && root.val <= this.high) {
            root.left = _trimBST(root.left, low, root.val);
            root.right = _trimBST(root.right, root.val, high);
            return root;
        } else if (root.val < this.low && high >= this.low)
            return _trimBST(root.right, root.val, high);
        else if (root.val > this.high && low <= this.high)
            return _trimBST(root.left, low, root.val);
        return null;
    }
}
