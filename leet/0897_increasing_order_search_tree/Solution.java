// LeetCode 897. Increasing Order Search Tree
// O(n) time, O(h) space
class Solution {
    TreeNode prev;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode();
        this.prev = dummy;
        inOrder(root);
        return dummy.right;
        
    }
    
    void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        root.left = null;
        prev.right = root;
        prev = root;
        inOrder(root.right);
    }
}
