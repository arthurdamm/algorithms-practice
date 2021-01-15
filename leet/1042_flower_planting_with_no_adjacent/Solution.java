// LeetCode 1042. Flower Planting With No Adjacent
// https://leetcode.com/problems/flower-planting-with-no-adjacent/
// O(n + m) time, O(n) space
class Solution {    
    public int[] gardenNoAdj(int n, int[][] paths) {
        int graph[][] = new int[n + 1][3];
        for (int[] path : paths) {
            connect(graph[path[0]], path[1]);
            connect(graph[path[1]], path[0]);
        }
        int ans[] = new int[n];
        backtrack(ans, 1, graph);
        for (int i = 0; i < ans.length; i++)
            if (ans[i] == 8)
                ans[i] = 3;
        return ans;
    }
    
    boolean backtrack(int[] ans, int i, int graph[][]) {
        if (i == ans.length + 1)
            return true;
        int colors = 1 | 2 | 4 | 8;
        for (int neighbor : graph[i]) {
            if (neighbor > 0)
                colors &= ~ans[neighbor - 1];
        }
        if (colors == 0)
            return false;
        for (int c = 0; c < 4; c++) {
            if ((colors & (1 << c)) != 0) {
                ans[i - 1] = (1 << c);
                if (backtrack(ans, i + 1, graph))
                    return true;
            }
            ans[i - 1] = 0;
        }
        return false;
    }
    
    void connect(int[] arr, int e) {
        int i = 0;
        for (i = 0; i < arr.length; i++)
            if (arr[i] == e)
                break;
        if (i != arr.length)
            return;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = e;
                break;
            }
        }
    }
}
