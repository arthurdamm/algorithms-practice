// LeetCode 993. Cousins in Binary Tree
// https://leetcode.com/problems/cousins-in-binary-tree/
// O(n) time-and-space
function isCousins(root: TreeNode | null, x: number, y: number): boolean {
    const queue = [root], cousins = new Set([x, y]), maybeCousins = {};
    while (queue.length) {
        for (let i = queue.length - 1; i >= 0; i--) {
            const node = queue.shift();
            if (cousins.has(node.left?.val))
                maybeCousins[node.left.val] = node;
            if (cousins.has(node.right?.val))
                maybeCousins[node.right.val] = node;
            node.left && queue.push(node.left);
            node.right && queue.push(node.right);
        }
        const maybeCousinsLength = Object.keys(maybeCousins).length;
        if (maybeCousinsLength > 0)
            return maybeCousinsLength == 2 && maybeCousins[x] != maybeCousins[y];
        
    }
    return false;
};

