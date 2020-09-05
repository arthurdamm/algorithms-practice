/*
1305. All Elements in Two Binary Search Trees
Medium O(n+m) time & space

Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> ret;
        int i = 0, j = 0;

        bst2list(root1, list1);
        bst2list(root2, list2);
        ret = new ArrayList<>(list1.size() + list2.size());
        while (i < list1.size() && j < list2.size())
        {
            if (list1.get(i) < list2.get(j))
                ret.add(list1.get(i++));
            else
                ret.add(list2.get(j++));
        }
        while (i < list1.size())
            ret.add(list1.get(i++));
        while (j < list2.size())
            ret.add(list2.get(j++));
        return ret;
    }

    void bst2list(TreeNode root, List<Integer> list)
    {
        if (root == null) return;
        bst2list(root.left, list);
        list.add(root.val);
        bst2list(root.right, list);
    }

    public static void main(String args) {}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
