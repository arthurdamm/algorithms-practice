// LeetCode 147. Insertion Sort List
// O(n^2) time, O(1) space

class Solution {
    public ListNode insertionSortList(ListNode head) {        
        if (head == null || head.next == null)
            return head;
        ListNode sorted = null, node, sorted_head = new ListNode(42);
        sorted_head.next = sorted = head;
        head = head.next;
        sorted_head.next.next = sorted.next = null;
        while (head != null) {
            node = head;
            head = head.next;
            if (node.val < sorted.val)
                sorted = sorted_head;
            while (sorted.next != null && node.val >= sorted.next.val)
                sorted = sorted.next;
            node.next = sorted.next;
            sorted.next = node;
        }
        return sorted_head.next;
        
    }
}
