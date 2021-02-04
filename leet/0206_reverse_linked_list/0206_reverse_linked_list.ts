// LeetCode 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/
// O(n) time, O(1) space
function reverseList(head: ListNode | null): ListNode | null {
    let prev = null;
    while (head) {
        let temp = head.next;
        head.next = prev;
        prev = head;
        head = temp;
    }
    return prev;
};

// recursive
function reverseList(head: ListNode | null): ListNode | null {
    if (!head || !head.next)
        return head;
    let node = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return node;
};
