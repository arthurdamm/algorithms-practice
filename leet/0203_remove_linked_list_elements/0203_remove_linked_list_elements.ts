// LeetCode 203. Remove Linked List Elements
// https://leetcode.com/problems/remove-linked-list-elements/
// O(n) time, O(1) space
function removeElements(head: ListNode | null, val: number): ListNode | null {
    let node = head, prev = null;
    while (node) {
        if (node.val === val) {
            if (node === head)
                head = node.next;
            else if (prev)
                prev.next = node.next;
        } else
            prev = node;
        node = node.next;
    }
    return head;
};

