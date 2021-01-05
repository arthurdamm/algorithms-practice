// LeetCode 82. Remove Duplicates from Sorted List II
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
// O(n) time, O(1) space
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode dummy, *prev = &dummy;
        dummy.next = NULL;
        while (head) {
            if (head->next && head->val == head->next->val) {
                while (head->next && head->val == head->next->val)
                    head->next = head->next->next;
                head = head->next;
                if (!head)
                    prev->next = NULL;
            } else {
                prev->next = head;
                prev = prev->next;
                head = head->next;
            }
        }
        return dummy.next;
    }
};
