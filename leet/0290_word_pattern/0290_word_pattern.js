// LeetCode 290. Word Pattern
// https://leetcode.com/problems/word-pattern/
// O(n) time-and-space
var wordPattern = function(pattern, s) {
    words = s.split(' ');
    if (pattern.length !== words.length)
        return false;
    const wordToLetter = new Map(), seenLetters = new Set();
    for (let i = 0; i < words.length; i++) {
        if (wordToLetter.has(words[i])) {
            if (wordToLetter.get(words[i]) !== pattern[i])
                return false;
        } else {
            if (seenLetters.has(pattern[i]))
                return false;
            wordToLetter.set(words[i], pattern[i]);
            seenLetters.add(pattern[i]);
        }
    }
    return true;
};
