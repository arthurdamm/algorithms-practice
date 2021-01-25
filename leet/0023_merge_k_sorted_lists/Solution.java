// LeetCode 23. Merge k Sorted Lists
// https://leetcode.com/problems/merge-k-sorted-lists/
// O(nlogk) time, O(k) space
class Solution {
    void p(Object o) { System.out.println(o); }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode saveHead = new ListNode(), head = saveHead;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->a.val - b.val);
        for (var list : lists)
            if (list != null)
                heap.offer(list);
        while (!heap.isEmpty()) {
            ListNode list = heap.poll();
            head.next = list;
            head = head.next;
            if (list.next != null)
                heap.offer(list.next);
        }
        return saveHead.next;
    }
}
