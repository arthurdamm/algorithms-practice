// LeetCode 563. Binary Tree Tilt
// O(n) time, O(logn) space
class Solution {
    int tiltSum = 0;
    
    public int findTilt(TreeNode root) {
        dfs(root);
        return this.tiltSum;
    }
    
    int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        this.tiltSum += Math.abs(left - right);
        return right + left + node.val;
    }
}

