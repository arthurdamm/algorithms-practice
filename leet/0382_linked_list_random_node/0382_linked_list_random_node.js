// LeetCode 382. Linked List Random Node
// https://leetcode.com/problems/linked-list-random-node/
// O(n) time, O(1)
var Solution = function(head) {
    this.head = head;
};

Solution.prototype.getRandom = function() {
    let k = this.head, node = this.head.next, n = 2;
    while (node) {
        if (Math.floor(Math.random() * n) === 0)
            k = node;
        node = node.next;
        n++;
    }
    return k.val;
};

