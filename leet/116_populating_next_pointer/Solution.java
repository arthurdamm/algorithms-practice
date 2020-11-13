// LeetCode 116. Populating Next Right Pointers in Each Node
// O(n) time, O(1) space
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node parent = root, first = root;
        while (parent.left != null) {
            for (; parent != null; parent = parent.next) {
                parent.left.next = parent.right;
                if (parent.next != null)
                    parent.right.next = parent.next.left;
            }
            parent = first.left;
            first = parent;
        }
        return root;
    }
}

