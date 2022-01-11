// 94. Binary Tree Inorder Traversal
// https://leetcode.com/problems/binary-tree-inorder-traversal/
// O(n) time, O(1) space -- Morris Traversal
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rightmost = curr.left;
                while (rightmost.right != null) {
                    if (rightmost.right == curr) {
                        rightmost.right = null;
                        inorder.add(curr.val);
                        curr = curr.right;
                        rightmost = null;
                        break;
                    }
                    rightmost = rightmost.right;
                }
                if (rightmost != null) {
                    rightmost.right = curr;
                    curr = curr.left;
                }
            }
        }
        return inorder;
    }
}
