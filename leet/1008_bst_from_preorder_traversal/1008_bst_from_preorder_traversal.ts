// LeetCode 1008. Construct Binary Search Tree from Preorder Traversal
// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// O(n) time, O(h) space
function bstFromPreorder(preorder: number[]): TreeNode | null {
    const root = new TreeNode(preorder[0]);
    let i = 1;
    const generateTree = (parent, minVal, maxVal) => {
        if (i >= preorder.length || preorder[i] > maxVal || preorder[i] < minVal)
            return;
        if (preorder[i] < parent.val) {
            const child = new TreeNode(preorder[i]);
            i++;
            parent.left = child;
            generateTree(child, minVal, parent.val);
        }
        
        if (i >= preorder.length || preorder[i] > maxVal || preorder[i] < minVal)
            return;
        if (preorder[i] > parent.val) {
            const child = new TreeNode(preorder[i]);
            i++;
            parent.right = child;
            generateTree(child, parent.val, maxVal);
        }
            
    };
    generateTree(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);
    return root;
};
