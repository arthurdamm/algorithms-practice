// LeetCode 143. Reorder List
// https://leetcode.com/problems/reorder-list/
// O(n) time, O(1) space
class Solution {
public:
    void reorderList(ListNode* head) {
        ListNode *slow = head, *fast = head;
        while (fast->next && fast->next->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode *node = slow->next, *prev = NULL, *next;
        while (node) {
            next = node->next;
            node->next = prev;
            prev = node;
            node = next;
        }
        
        node = prev;
        ListNode *next1 = NULL, *next2 = NULL;
        while (node) {
            next1 = head->next;
            next2 = node->next;
            head->next = node;
            node->next = next1;
            head = next1;
            node = next2;
        }
        if (next1)
            next1->next = NULL;
        
    }
};
