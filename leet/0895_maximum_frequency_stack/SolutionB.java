// LeetCode 895. Maximum Frequency Stack
// push() & pop() O(1) time, O(n) space
class FreqStack {
    int max = 0;
    Map<Integer, Integer> counts = new HashMap<>();
    Map<Integer, Stack<Integer>> buckets = new HashMap<>();

    public FreqStack() {
        
    }
    
    public void push(int x) {
        int k = counts.getOrDefault(x, 0) + 1;
        counts.put(x, k);
        max = Math.max(max, k);
        if (!buckets.containsKey(k))
            buckets.put(k, new Stack<>());
        buckets.get(k).push(x);
    }
    
    public int pop() {
        int x = buckets.get(max).pop();
        if (buckets.get(max).empty())
            max--;
        counts.put(x, counts.get(x) - 1);
        return x;
    }
}
