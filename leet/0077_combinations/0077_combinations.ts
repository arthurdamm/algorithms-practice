// LeetCode 77. Combinations
// https://leetcode.com/problems/combinations/
// O(nCk) time-and-space
function combine(n: number, k: number): number[][] {
    const combos = [];
    const dfs = (index, left, combo) => {
        if (left-- === 0)
            return combos.push(combo);
        for (let i = index; i <= n - left; i++)
            dfs(i + 1, left, combo | (1 << (i - 1)));
    }
    dfs(1, k, 0);
    let oneToN = new Array(n).fill(0).map((x, i) => i + 1);
    return combos.map(c => oneToN.filter(i => c & (1 << (i - 1))));
};
