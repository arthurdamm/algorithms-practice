// LeetCode 143. Reorder List
// https://leetcode.com/problems/reorder-list/
// O(n) time-and-space
class Solution {
    ListNode head;
    boolean stop = false;
    public void reorderList(ListNode head) {
        if (head.next != null && head.next.next != null) {
            this.head = head;
            interpolateRecursively(head.next);
        }
    }
    
    private void interpolateRecursively(ListNode node) {
        if (node.next != null)
            interpolateRecursively(node.next);
        if (!stop) {
            ListNode temp = head.next;
            if (node == temp || node == head) {
                stop = true;
                node.next = null;
            } else if (!stop) {
                head.next = node;
                node.next = temp;
                head = temp;
            }
        }
    }
}

