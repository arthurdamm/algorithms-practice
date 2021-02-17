// LeetCode 784. Letter Case Permutation
// https://leetcode.com/problems/letter-case-permutation/
// O(2^n) time-and-space
function letterCasePermutation(S: string): string[] {
    function backtrack(str: string[], i: number) {
        if (i == S.length) {
            ret.push(str.join(''));
            return;
        }
        if (str[i] >= '0' && str[i] <= '9')
            backtrack(str, i + 1);
        else {
            str[i] = str[i].toUpperCase();
            backtrack(str, i + 1);
            str[i] = str[i].toLowerCase();
            backtrack(str, i + 1);
        }
    }
    const ret = [];
    backtrack(S.split(''), 0);
    return ret;
};
