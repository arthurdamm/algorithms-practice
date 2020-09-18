// LeetCode 1252. Cells with Odd Values in a Matrix
// O(k) time O(m+n) space
class SolutionB {
    public int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] cols = new int[m];
        int r = 0, c = 0;
        for (int i = 0; i < indices.length; i++) {
            if ((rows[indices[i][0]] ^= 1) == 1)
                r++;
            else
                r--;         
            if ((cols[indices[i][1]] ^= 1) == 1)
                c++;
            else
                c--;
        }
        return m * r + n * c - 2 * r * c;
        
    }
}
