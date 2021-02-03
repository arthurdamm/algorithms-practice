// LeetCode 142. Linked List Cycle II
// https://leetcode.com/problems/linked-list-cycle-ii/
// O(n) time, O(1) space
function detectCycle(head: ListNode | null): ListNode | null {
    let slow = head, fast = head;
    while (fast && fast.next) {
        fast = fast.next.next;
        slow = slow.next;
        if (slow == fast) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
    return null;
};
