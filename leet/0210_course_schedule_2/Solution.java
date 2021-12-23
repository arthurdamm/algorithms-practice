// LeetCode 210. Course Schedule II
// https://leetcode.com/problems/course-schedule-ii/
// O(n^2) time-and-space
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> edges = new HashMap();
        Map<Integer, Integer> havePreqs = new HashMap();
        int solution[] = new int[numCourses], i = 0, j = 0;
        for (int[] preq : prerequisites) {
            var list = edges.getOrDefault(preq[1], new ArrayList<Integer>());
            list.add(preq[0]);
            edges.put(preq[1], list);
            havePreqs.put(preq[0], havePreqs.getOrDefault(preq[0], 0) + 1);
        }
        for (i = 0; i < numCourses; i++) {
            if (!havePreqs.containsKey(i)) {
                solution[j++] = i;
            }
        }
        i = 0;
        while (i < j) {
            int n = solution[i++];
            for (int nextCourse : edges.getOrDefault(n, new ArrayList<Integer>())) {
                if (havePreqs.containsKey(nextCourse)) {
                    havePreqs.put(nextCourse, havePreqs.get(nextCourse) - 1);
                    if (havePreqs.get(nextCourse) > 0)
                        continue;
                }
                solution[j++] = nextCourse;

            }
        }
        return i == numCourses ? solution : new int[0];
    }
}

