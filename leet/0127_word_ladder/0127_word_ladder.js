/*
LeetCode https://leetcode.com/problems/word-ladder/
O(w*l^2) time, w=words l=length of word, O(w*l) space
Key Insight: BFS graph problem, words different by 1 char are neighbors
*/
var ladderLength = function(beginWord, endWord, wordList) {
    const wordSet = new Set(wordList);
    if (!wordSet.has(endWord))
        return 0;
    const queue = [beginWord];
    let steps = 1, i = 0;
    while (i < queue.length) {
        for (sz = queue.length - i; sz > 0; sz--) {
            const word = queue[i++];
            if (word === endWord)
                return steps;
            findNeighbors(word, wordSet).forEach(nextWord => queue.push(nextWord));
        }
        steps++;
    }
    return 0;
};

function findNeighbors(word, wordSet) {
    const neighbors = [];
    for (let i = 0; i < word.length; i++) {
        for (const c of "abcdefghijklmnopqrstuvwxyz") {
            const nextWord = word.slice(0, i) + c + word.slice(i + 1);
            if (wordSet.has(nextWord)) {
                wordSet.delete(nextWord);
                neighbors.push(nextWord);
            }
        }
    }
    return neighbors;
}
