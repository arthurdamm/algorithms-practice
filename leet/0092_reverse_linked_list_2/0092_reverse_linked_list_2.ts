// LeetCode 92. Reverse Linked List II
// https://leetcode.com/problems/reverse-linked-list-ii/
// O(n) time, O(1) space
function reverseBetween(head: ListNode | null, m: number, n: number): ListNode | null {
    let origHead = head, prevHead = null, prev = null;
    for (let i = 1; i < m; i++) {
        prevHead = head;
        head = head.next;
    }
    for (let i = m; i <= n; i++) {
        let next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    if (prevHead) {
        prevHead.next.next = head;
        prevHead.next = prev;
        return origHead;
    }
    origHead.next = head;
    return prev;
};
