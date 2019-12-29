/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number[][]}
 */
var pathSum = function(root, sum) {

    var ret = [];
    
    var dfs = (node, path, goal) => {
        if (!node) return;
        path.push(node.val);
        if (!node.left && !node.right && node.val == goal) {
            ret.push(path.slice());
        }
        x = dfs(node.left, path, goal - node.val);
        y= dfs(node.right, path, goal - node.val);
        
        path.pop();
    }
    dfs(root, [], sum);
    return ret;
    
};

