// LeetCode 21. Merge Two Sorted Lists
// https://leetcode.com/problems/merge-two-sorted-lists/
// O(n) time O(1) space
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode dummy, *head = &dummy;
        dummy.next = NULL;
        while (l1 && l2) {
            if (l1->val <= l2->val) {
                head->next = l1;
                l1 = l1->next;
            } else {
                head->next = l2;
                l2 = l2->next;
            }
            head = head->next;
        }
        if (l1)
            head->next = l1;
        if (l2)
            head->next = l2;
        return dummy.next;
    }
};

// O(n) time O(n) space
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (!l1)
            return l2;
        else if (!l2)
            return l1;
        else if (l1->val <= l2->val) {
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        } else {
            l2->next = mergeTwoLists(l1, l2->next);
            return l2;
        }
    }
};
