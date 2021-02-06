// LeetCode 199. Binary Tree Right Side View
// https://leetcode.com/problems/binary-tree-right-side-view/
// O(n) time, O(h) space
function rightSideView(root: TreeNode | null): number[] {
    const dfs = (root, depth) => {
        if (!root)
            return;
        rightNodes[depth] = root.val;
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);  
    };
    const rightNodes = {};
    dfs(root, 0);
    return Object.values(rightNodes);
};
