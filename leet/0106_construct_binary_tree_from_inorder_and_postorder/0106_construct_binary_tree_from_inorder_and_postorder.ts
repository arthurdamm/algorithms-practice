// LeetCode 106. Construct Binary Tree from Inorder and Postorder Traversal
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// O(n) time-and-space
function buildTree(inorder: number[], postorder: number[]): TreeNode | null {
    const postorderValToIndex = new Map<number, number>();
    postorder.forEach((val, i) => postorderValToIndex.set(val, i));
    const recurse = (inorder: number[]):TreeNode | null => {
        if (!inorder.length)
            return null;
        let rootPostorderIndex = -1;
        let rootInorderIndex = -1;
        for (let i = 0; i < inorder.length; i++) {
            const postorderIndex = postorderValToIndex.get(inorder[i]);
            if (postorderIndex > rootPostorderIndex) {
                rootPostorderIndex = postorderIndex;
                rootInorderIndex = i;
            }
        }
        const root = new TreeNode(inorder[rootInorderIndex]);
        root.left = recurse(inorder.slice(0, rootInorderIndex));
        root.right = recurse(inorder.slice(rootInorderIndex + 1));
        return root;
    }
    return recurse(inorder);
};
