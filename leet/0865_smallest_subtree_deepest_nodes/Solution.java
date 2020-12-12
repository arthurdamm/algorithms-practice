// LeetCode 865. Smallest Subtree with all the Deepest Nodes
// O(n) time O(n) space
class Solution {
    Map<TreeNode, Integer> depths = new HashMap<>();
    int max_depth = Integer.MIN_VALUE;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        for (int depth: this.depths.values())
            this.max_depth = Math.max(this.max_depth, depth);
        return ancestor(root);
    }
    
    void dfs(TreeNode node, int depth) {
        if (node == null)
            return;
        depth += 1;
        this.depths.put(node, depth);
        dfs(node.left, depth);
        dfs(node.right, depth);
    }
    
    TreeNode ancestor(TreeNode node) {
        if (node == null || this.depths.get(node) == this.max_depth)
            return node;
        TreeNode left = ancestor(node.left);
        TreeNode right = ancestor(node.right);
        if (left != null && right != null)
            return node;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
