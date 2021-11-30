// LeetCode 721. Accounts Merge
// https://leetcode.com/problems/accounts-merge/
// O(nmlog(nm)) time complexity, O(nm) space complexity
function accountsMerge(accounts: string[][]): string[][] {
    const vertices = new Map<string, string[]>();
    const emailToName = new Map<string, string>();
    for (const account of accounts) {
        emailToName.set(account[1], account[0]);
        if (!vertices.get(account[1]))
            vertices.set(account[1], []);
        for (let i = 2; i < account.length; i++) {
            if(!vertices.has(account[i]))
                vertices.set(account[i], []);
            vertices.get(account[i]).push(account[i - 1]);
            vertices.get(account[i - 1]).push(account[i]);
        }
    }
    const solution = [];
    const visited = new Set();
    let name, emails;
    const dfs = (vertex) => {
        if (visited.has(vertex))
            return;
        visited.add(vertex);
        emails.push(vertex);
        if (!name && emailToName.has(vertex))
            name = emailToName.get(vertex);
        vertices.get(vertex).forEach(nextVertex => dfs(nextVertex));
    }
    for (const vertex of vertices.keys()) {
        name = null;
        emails = [];
        dfs(vertex);
        if (name)
            solution.push([name, ...emails.sort()]);
    }
    return solution;
};
