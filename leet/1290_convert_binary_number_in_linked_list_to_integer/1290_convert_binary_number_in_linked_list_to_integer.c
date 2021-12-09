// LeetCode 1290. Convert Binary Number in a Linked List to Integer
// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
// O(n) time, O(1) space
int getDecimalValue(struct ListNode* head){
    int num = 0;
    while (head) {
        num = num << 1 | head->val;
        head = head->next;
    }
    return num;
}
