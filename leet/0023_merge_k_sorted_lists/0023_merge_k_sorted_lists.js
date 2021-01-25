// LeetCode 23. Merge k Sorted Lists
// https://leetcode.com/problems/merge-k-sorted-lists/
// O(nlogk) time, O(logk) space
var mergeKLists = function(lists) {
    
    let divideAndConquerLists = function(lists, start, end) {
        if (start >= end)
            return lists[start];
        let mid = parseInt(start + (end - start) / 2);
        let left = divideAndConquerLists(lists, start, mid);
        let right = divideAndConquerLists(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    
    let mergeTwoLists = function(list1, list2) {
        let dummy = new ListNode(), head = dummy;
        while (list1 && list2) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1)
            head.next = list1;
        if (list2)
            head.next = list2;
        return dummy.next;
    }
    
    if (!lists.length)
        return null;
    return divideAndConquerLists(lists, 0, lists.length);
};
