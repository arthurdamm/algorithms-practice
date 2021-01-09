// LeetCode 127. Word Ladder
// https://leetcode.com/problems/word-ladder/
// O(M^2*N) time and space
class Solution {
    Set<String> words;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        words = new HashSet<String>(wordList);
        if (!words.contains(endWord))
            return 0;
        int steps = 2;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            for (int sz = queue.size(); sz > 0; sz--) {
                for (String neighbor : findNeighbors(queue.poll())) {
                    if (neighbor.equals(endWord))
                        return steps;
                    queue.offer(neighbor);
                }
            }
            steps++;
        }
        return 0;
    }
    
    ArrayList<String> findNeighbors(String word) {
        char[] chars = word.toCharArray();
        ArrayList<String> neighbors = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String newWord = new String(chars);
                if (this.words.contains(newWord)) {
                    neighbors.add(newWord);
                    this.words.remove(newWord);
                }
            }
            chars[i] = temp;
        }
        return neighbors;
    }
}

// O(M^2*N) time and space
class SolutionB {
    Set<String> words, beginSet = new HashSet<>(), endSet = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        words = new HashSet<String>(wordList);
        if (!words.contains(endWord))
            return 0;
        words.remove(endWord);
        beginSet.add(beginWord);
        endSet.add(endWord);
        int steps = 1;
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                var temp = endSet;
                endSet = beginSet;
                beginSet = temp;
            }
            var newSet = new HashSet<String>();
            for (String word : beginSet) {
                if (endSet.contains(word))
                    return steps;
                newSet.addAll(findNeighbors(word));
            }
            beginSet = newSet;
            steps++;
        }
        return 0;
    }
    
    ArrayList<String> findNeighbors(String word) {
        char[] chars = word.toCharArray();
        ArrayList<String> neighbors = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String newWord = new String(chars);
                if (this.words.contains(newWord)) {
                    neighbors.add(newWord);
                    this.words.remove(newWord);
                }
                if (this.endSet.contains(newWord))
                    neighbors.add(newWord);
            }
            chars[i] = temp;
        }
        return neighbors;
    }
}

