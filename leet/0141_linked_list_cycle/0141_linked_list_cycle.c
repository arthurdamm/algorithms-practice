// LeetCode 141. Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/
// O(n) time, O(1) space
bool hasCycle(struct ListNode *head) {
    struct ListNode *slow = head, *fast = head;
    while (fast && fast->next) {
        fast = fast->next->next;
        slow = slow->next;
        if (fast == slow)
            return true;
    }
    return false;
}
