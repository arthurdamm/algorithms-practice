// LeetCode 895. Maximum Frequency Stack
// push() & pop() O(logn) time, O(n) space
class Tuple {
    int n;
    int k;
    int i;
    Tuple(int n, int k, int i) { this.n = n; this.k = k; this.i = i; }
}

class FreqStack {
    int i = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Tuple> pq = new PriorityQueue<>(
        (t1, t2) -> t2.k == t1.k ? t2.i - t1.i : t2.k - t1.k);
    
    public FreqStack() {
    }
    
    public void push(int x) {
        int k = map.getOrDefault(x, 0) + 1;
        map.put(x, k);
        pq.add(new Tuple(x, k, i++));
    }
    
    public int pop() {
        int n = pq.poll().n;
        map.put(n, map.get(n) - 1);
        return n;
    }
}
