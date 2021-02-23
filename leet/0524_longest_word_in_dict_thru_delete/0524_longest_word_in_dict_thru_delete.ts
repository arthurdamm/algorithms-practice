// LeetCode 524. Longest Word in Dictionary through Deleting
// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
// O(mn) time, O(1) space
function findLongestWord(s: string, d: string[]): string {
    let match = "";
    for (let word of d) {
        if (s.length < word.length || word.length < match.length)
            continue;
        for (let i = 0, j = 0; i < s.length; i++)
            if (s[i] == word[j])
                if (++j == word.length)
                    if (word.length > match.length ||
                        (word.length == match.length && word < match))
                        match = word;
                    
    }
    return match;
};
