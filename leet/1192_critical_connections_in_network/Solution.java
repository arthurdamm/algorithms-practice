// LeetCode 1192. Critical Connections in a Network
// https://leetcode.com/problems/critical-connections-in-a-network/
// O(n) time-and-space, simplified Tarjan's Algorithm for Bridges
class Solution {
    List<List<Integer>> bridges = new ArrayList();
    List<Integer>[] adjacency;
    int[] pre;
    int[] low;
    int cnt = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adjacency = new ArrayList[n];
        pre = new int[n];
        low = new int[n];
        Arrays.fill(pre, -1);
        
        for (int i = 0; i < n; i++)
            adjacency[i] = new ArrayList();
        for (var connection : connections) {
            adjacency[connection.get(0)].add(connection.get(1));
            adjacency[connection.get(1)].add(connection.get(0));
        }
        
        for (int i = 0; i < n; i++)
            if (pre[i] == -1)
                dfs(i, i);
        return bridges;
    }
    
    private void dfs(int u, int v) {
        pre[v] = cnt++;
        low[v] = pre[v];
        for (int w : adjacency[v]) {
            if (pre[w] == -1) {
                dfs(v, w);
                low[v] = Math.min(low[v], low[w]);
                if (low[w] == pre[w]) {
                    bridges.add(new ArrayList(Arrays.asList(new Integer[]{v, w})));
                }
            } else if (u != w)
                low[v] = Math.min(low[v], pre[w]);
        }
    }
}
