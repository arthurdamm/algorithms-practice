// LeetCode 148. Sort List
// O(nlogn) time, O(1) space (not counting logarithmic recursive parameters =P)
 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        head = sortList(head);
        fast = sortList(fast);
        return merge(head, fast);
    }
    
    ListNode merge(ListNode list1, ListNode list2) {
        ListNode merged, merged_head;
        
        if (list1.val < list2.val) {
            merged = list1;
            list1 = list1.next;
        } else {
            merged = list2;
            list2 = list2.next;
        }
        merged_head = merged;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                merged.next = list1;
                list1 = list1.next;
            } else {
                merged.next = list2;
                list2 = list2.next;
            }
            merged = merged.next;
        }
        
        merged.next = list1 != null ? list1 : list2;
        return merged_head;
    }
}
