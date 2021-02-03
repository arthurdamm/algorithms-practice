// LeetCode 141. Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/
// O(n) time, O(1) space
function hasCycle(head: ListNode | null): boolean {
    let slow = head, fast = head;
    while (fast && fast.next) {
        fast = fast.next.next;
        slow = slow.next;
        if (slow == fast)
            return true	;
    }
    return false;
};
