// LeetCode 160. Intersection of Two Linked Lists
// https://leetcode.com/problems/intersection-of-two-linked-lists/
// O(n) time, O(1) space
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode node = headA;
        while (node != null) {
            lenA++;
            node = node.next;
        }
        int lenB = 0;
        node = headB;
        while (node != null) {
            lenB++;
            node = node.next;
        }
        if (lenA < lenB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        for (int i = 0; i < Math.abs(lenA - lenB); i++)
            headA = headA.next;
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
