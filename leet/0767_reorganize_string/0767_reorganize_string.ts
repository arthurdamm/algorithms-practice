// LeetCode 767. Reorganize String
// https://leetcode.com/problems/reorganize-string/
// O(n) time-and-space
function reorganizeString(S: string): string {
    const count = new Array(26).fill(0);
    for (let i = 0; i < S.length; i++)
        count[S.charCodeAt(i) - 97]++;
    const ret = new Array(S.length);
    for (let i = 0; i < Math.floor(S.length / 2); i++) {
        let max1 = -1, max2 = -1;
        
        for (let j = 0; j < 26; j++) {
            if (count[j] == 0)
                continue;
            if (max1 == -1 || count[j] > count[max1]) {
                max2 = max1;
                max1 = j;
            } else if (max2 == -1 || count[j] > count[max2])
                max2 = j;
        }
        
        if (max1 == -1 || max2 == -1 || --count[max1] < 0 || --count[max2] < 0)
            return "";
        if (i == 0 || ret[(i - 1) * 2] == max1 || ret[(i - 1) * 2 + 1] == max2) {
            ret[i * 2] = max1;
            ret[i * 2 + 1] = max2;
        } else {
            ret[i * 2] = max2;
            ret[i * 2 + 1] = max1;
        }
    }
    for (let j = 0; j < 26; j++)
        if (count[j] > 0)
            ret[ret.length - 1] = j;
    return ret.map(c => String.fromCharCode(c + 97)).join("");
};
