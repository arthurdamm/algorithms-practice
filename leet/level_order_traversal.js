/** LeetCode 102 Binary Tree Level Order Traversal
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if (!root) return [];
    queue = [root]
    ret = []
    while (level = queue.length) {
        subret = []
        for (i = 0; i < level; i++) {
            node = queue.shift();
            subret.push(node.val);
            node.left && queue.push(node.left)
            node.right && queue.push(node.right)
        }
        ret.push(subret)
    }
    return ret;
};
