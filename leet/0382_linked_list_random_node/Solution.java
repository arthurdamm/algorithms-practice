// LeetCode 382. Linked List Random Node
// O(N) time, O(1) space

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int len = 0;
    ListNode head = null;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        int i = 0;
        for (; head != null; i++)
            head = head.next;
        this.len = i;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        // int x = ThreadLocalRandom.current().nextInt(0, this.len);
        int x = (int)(Math.random() * this.len);
        ListNode node = this.head;
        for (; x > 0; x--)
            node = node.next;
        return node.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
