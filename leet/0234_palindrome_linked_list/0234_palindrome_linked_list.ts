// LeetCode 234. Palindrome Linked List
// https://leetcode.com/problems/palindrome-linked-list/
// O(n) time, O(1) space
function isPalindrome(head: ListNode | null): boolean {    
    if (!head || !head.next)
        return true;
    if (!head.next.next)
        return head.val == head.next.val;
    let slow = head, fast = head.next;
    while (fast && fast.next) {
        fast = fast.next.next;
        slow = slow.next;
    }
    // slow is now before head to reverse
    let prev = null, next;
    for (let node = slow.next; node; node = next) {
        next = node.next;
        node.next = prev;
        prev = node;
    }
    // prev now points to new head
    for (let node = prev; node; node = node.next) {
        if (node.val != head.val)
            return false;
        head = head.next;
    }
    
    // restore second half of list
    let node = prev;
    prev = null
    while (node) {
        let next = node.next;
        node.next = prev;
        prev = node;
        node = next;
    }
    return true;
};
