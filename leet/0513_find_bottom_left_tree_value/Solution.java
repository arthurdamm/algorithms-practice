// LeetCode 513. Find Bottom Left Tree Value
// O(n) time, O(n) space
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int leftmost = -1;
        while (!queue.isEmpty()) {
            leftmost = queue.peek().val;
            for (int sz = queue.size(); sz > 0; sz--) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return leftmost;
    }
}
