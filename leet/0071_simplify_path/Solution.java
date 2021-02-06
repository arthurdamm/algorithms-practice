// LeetCode 71. Simplify Path
// https://leetcode.com/problems/simplify-path/
// O(n) time-and-space
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> ignore = new HashSet<>(Arrays.asList(new String[]{"", "."}));
        for (var part : path.split("/")) {
            if (!ignore.contains(part)) {
                if (part.equals("..")) {
                    if (!stack.isEmpty())
                        stack.removeLast();
                } else
                    stack.addLast(part);
            }
        }
        return "/" + String.join("/", stack);
    }
}
