// LeetCode 103. Binary Tree Zigzag Level Order Traversal
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// O(n) time-and-space
var zigzagLevelOrder = function(root) {
    if (!root)
        return [];
    let stack = [root], ret = [];
    for (let level = 0; stack.length > 0; level++) {
        let current = [], stack2 = []
        for (let sz = stack.length; sz > 0; sz--) {
            let node = stack.pop();
            current.push(node.val);
            let order = (level % 2 == 0 ? [node.left, node.right] : [node.right, node.left]);
            for (let child of order)
                if (child)
                    stack2.push(child);
        }
        ret.push(current);
        stack = stack2;
    }
    return ret;
};
