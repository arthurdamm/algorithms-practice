// LeetCode 239. Sliding Window Maximum
// https://leetcode.com/problems/sliding-window-maximum/submissions/
// O(nlogk) time, O(n) space
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<tuple<int, int>> heap;
        vector<int> ans;
        for (int i = 0; i < nums.size(); i++) {
            // insert new element in heap
            heap.push_back(make_tuple(nums[i], i));
            push_heap(heap.begin(), heap.end());
            // Purse old elements from top of heap
            while (get<1>(heap.front()) <= i - k) {
                pop_heap(heap.begin(), heap.end());
                heap.pop_back();
            }
            // add current max to ans
            if (i >= k - 1)
                ans.push_back(get<0>(heap.front()));
        }
        return ans;
    }
};

// O(n) time, O(k) space
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> ans;
        deque<int> deck;
        for (int i = 0; i < nums.size(); i++) {
            if (!deck.empty() && deck.front() <= i - k)
                deck.pop_front();
            int currmax = deck.empty() ? nums[i] : max(nums[i], nums[deck.front()]);
            while (!deck.empty() && nums[deck.back()] <= nums[i])
                deck.pop_back();
            deck.push_back(i);
            if (i >= k - 1)
                ans.push_back(currmax);
        }
        return ans;
    }
};
