// LeetCode 382. Linked List Random Node
// https://leetcode.com/problems/linked-list-random-node/
// O(N) time, O(1) space
class Solution {
public:
    ListNode* head;
    
    Solution(ListNode* head) {
        srand(time(NULL));
        this->head = head;
    }
    
    int getRandom() {
        int k = head->val, n = 2;
        for (ListNode *node = head->next; node; node = node->next) {
            if (!(rand() % n++))
                k = node->val;
        }
        return k;
    }
};

