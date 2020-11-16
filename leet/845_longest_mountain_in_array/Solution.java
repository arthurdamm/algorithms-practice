class Solution {
    public int longestMountain(int[] A) {
        final int NONE = 0, UP = 1, DOWN = 2;
        int m = 0, max = 0, state = NONE;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                if (state != UP) {
                    if (state == DOWN) {
                        max = Math.max(max, m);
                    }
                    m = 1;
                    state = UP;
                }
                m++;
            } else if (A[i - 1] > A[i]) {
                if (state == UP || state == DOWN) {
                    state = DOWN;
                    m++;
                } else
                    state = NONE;
            } else {
                if (state == DOWN) {
                    max = Math.max(max, m);
                }
                state = NONE;
            }
        }
        if (state == DOWN)
            max = Math.max(max, m);
        return max >= 3 ? max : 0;
    }
}