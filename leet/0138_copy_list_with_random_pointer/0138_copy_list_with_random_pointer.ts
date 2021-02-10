// LeetCode 138. Copy List with Random Pointer
// https://leetcode.com/problems/copy-list-with-random-pointer/
// O(n) time-and-space
function copyRandomList(head: Node | null): Node | null {
    let map:Map<Node, Node> = new Map();
    
    for (let node = head; node; node = node.next)
        map.set(node, new Node(node.val));
    for (let node = head; node; node = node.next) {
        let copy = map.get(node);
        copy.next = node.next ? map.get(node.next) : null;
        copy.random = node.random ? map.get(node.random) : null;
    }
    return map.get(head);
};
