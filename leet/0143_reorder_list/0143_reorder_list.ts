// LeetCode 143. Reorder List
// https://leetcode.com/problems/reorder-list/
// O(n) time-and-space
function reorderList(head: ListNode | null): void {
    let stop = false;
    if (!head.next || ! head.next.next)
        return;
    const interpolateRecursively = (node: ListNode): null => {
        if (node.next)
            interpolateRecursively(node.next);
        if (stop)
            return;
        const temp = head.next;
        if (node === temp || node === head) {
            stop = true;
            node.next = null;
        } else {
            head.next = node;
            node.next = temp;
            head = temp;
        }
    }
    interpolateRecursively(head);
};

