// LeetCode 199. Binary Tree Right Side View
// https://leetcode.com/problems/binary-tree-right-side-view/
// O(n) time, O(h) space
class Solution {
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return this.list;
    }
    
    private void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth > this.list.size() - 1)
            this.list.add(0);
        this.list.set(depth, root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
