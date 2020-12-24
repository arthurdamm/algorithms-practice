// LeetCode 24. Swap Nodes in Pairs
// https://leetcode.com/problems/swap-nodes-in-pairs/
// O(n) time O(1) space
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode _head = new ListNode(), prev = _head, next;
        
        prev.next = head;
        while (head != null && head.next != null) {
            next = head.next;
            head.next = next.next;
            next.next = head;
            prev.next = next;
            
            prev = head;
            head = head.next;
        }
        return _head.next;
    }
}

class SolutionB {
    public ListNode swapPairs(ListNode head) {        
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
