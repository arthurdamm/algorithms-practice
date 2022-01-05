// 131. Palindrome Partitioning
// https://leetcode.com/problems/palindrome-partitioning/
// O(n*2^n) time, O(n^2) space
var partition = function(s) {
    const solutions = [];
    dp = Array(s.length);
    const isPali = (s, i, j) => {
        for (; i < j; i++, j--)
            if (s[i] !== s[j])
                return false;
        return true;
    }
    const makeDP = () => {
        for (let i = 0; i < s.length; i++) {
            dp[i] = [];
            for (let j = 0; i + j < s.length; j++) {
                if (isPali(s, i, i + j))
                    dp[i].push(s.slice(i, i + j + 1));
            }
        }
    }
    makeDP();
    
    const dfs = (i, partition) => {
        if (i === s.length) {
            solutions.push([...partition])
            return;
        }
        for (const pali of dp[i]) {
            partition.push(pali);
            dfs(i + pali.length, partition);
            partition.pop();
        }
    }
    dfs(0, []);
    return solutions;
};
