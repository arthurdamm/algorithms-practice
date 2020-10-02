// LeetCode 933. Number of Recent Calls
// Time O(n) Space O(n)
class RecentCounter {
    Deque<Integer> deque = new LinkedList<>();
    public RecentCounter() {
    }
    
    public int ping(int t) {
        while (this.deque.size() > 0 && this.deque.peek() < t - 3000)
            this.deque.removeFirst();
        this.deque.addLast(t);
        return this.deque.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
