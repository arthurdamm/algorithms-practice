// LeetCode 2 Add Two Numbers
// O(n) time & space
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    let n1, n2, sum, retlist, ret, carry = 0;
    while (l1 || l2) {
        n1 = n2 = sum = 0;
        if (l1) {
            n1 = l1.val;
            l1 = l1.next;
        }
        if (l2) {
            n2 = l2.val;
            l2 = l2.next;
        }
        sum = n1 + n2 + carry;
        carry = parseInt(sum / 10);
        sum %= 10;
        let node = {val: sum, next: null};
        if (!retlist) ret = retlist = node;
        else retlist = retlist.next = node;
    }
    if (carry)
        retlist = retlist.next = {val: carry, next: null};
    return ret;
};

