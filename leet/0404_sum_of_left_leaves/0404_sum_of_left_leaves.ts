// LeetCode 404. Sum of Left Leaves
// https://leetcode.com/problems/sum-of-left-leaves/
// O(n) time, O(h) space
function sumOfLeftLeaves(root: TreeNode | null): number {
    const dfs = (node, isLeft) =>
        node ? dfs(node.left, true) + dfs(node.right, false) + (isLeft && !node.left && !node.right ? node.val : 0) : 0;
    return dfs(root, false);
};
