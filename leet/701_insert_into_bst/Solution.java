// LeetCode 701. Insert into a Binary Search Tree
// O(logn) time, O(1) space
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root, prev = root, newNode = new TreeNode(val);
        if (root == null)
            return newNode;
        while (node != null) {
            prev = node;
            if (val < node.val)
                node = node.left;
            else
                node = node.right;
        }
        if (val < prev.val)
            prev.left = newNode;
        else
            prev.right = newNode;
        return root;
    }
}

