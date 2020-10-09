/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int i = 0;
    String[] values;
    
    void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }
    
    TreeNode insert() {
        if (this.i >= values.length  || values[this.i].equals("N")) {
            this.i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(values[this.i++]));
        root.left = insert();
        root.right = insert();
        return root;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.values = data.split(",");
        return insert();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
