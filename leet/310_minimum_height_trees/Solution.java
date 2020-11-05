// 310. Minimum Height Trees
// O(n) time O(n) space
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        LinkedList<Integer> queue = new LinkedList<>();
        
        if (n == 1) {
            queue.add(0);
            return queue;
        }
            
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList();
        for (int[] edge : edges) { 
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        
        for (int i = 0; i < n; i++)
            if (adj[i].size() == 1)
                queue.add(i);
        
        int c = 0;
        while (n - c > 2) {
            int sz = queue.size();
            c += sz;
            for (int i = 0; i < sz; i++) {
                int k = queue.poll();
                int l = adj[k].get(0);
                adj[l].remove(Integer.valueOf(k));
                if (adj[l].size() == 1)
                    queue.add(l);
            }
        }
        return queue;
    }
}

