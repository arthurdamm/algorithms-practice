// LeetCode 865. Smallest Subtree with all the Deepest Nodes
// O(n) time O(n) space
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
    	Map<TreeNode, TreeNode> parents = new HashMap<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            boolean children = false;
            for (TreeNode node : queue)
                if ((node.left != null) || (node.right != null))
                    children = true;
            if (!children)
                break;
            while (sz-- > 0) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    parents.put(node.left, node);
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    parents.put(node.right, node);
                    queue.addLast(node.right);
                }
            }
        }
        if (queue.size() == 1)
            return queue.removeFirst();
        TreeNode[] leaves = new TreeNode[queue.size()];
        queue.toArray(leaves);
        while (true) {
            boolean found = true;
            TreeNode match = null;
            for (int i = 0; i < leaves.length; i++) {
                if (match == null)
                    match = leaves[i] = parents.get(leaves[i]);
                else {
                    leaves[i] = parents.get(leaves[i]);
                    if (leaves[i] != match)
                        found = false;
                }
            }
            if (found)
                break;
        }
        return leaves[0];
    }
   
}