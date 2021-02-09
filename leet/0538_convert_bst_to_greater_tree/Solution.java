// LeetCode 538. Convert BST to Greater Tree
// https://leetcode.com/problems/convert-bst-to-greater-tree/
// O(n) time, O(h) space
class Solution {
    public TreeNode convertBST(TreeNode root) {
        sumRight(root, 0);
        return root;
    }
    
    private int sumRight(TreeNode root, int greater) {
        if (root == null)
            return greater;
        int rightSum = sumRight(root.right, greater);
        int leftSum = sumRight(root.left, root.val + rightSum);
        root.val += rightSum;
        return leftSum;
    
    }
}
