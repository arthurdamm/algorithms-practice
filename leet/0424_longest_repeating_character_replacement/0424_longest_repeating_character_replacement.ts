// LeetCode 424. Longest Repeating Character Replacement
// https://leetcode.com/problems/longest-repeating-character-replacement/
// O(n) time-and-space
function characterReplacement(s: string, k: number): number {
    let count = new Array(26).fill(0);
    let maxIndex = 0, _k = k, maxWindow = 0;
    for (let left = 0, right = 0; right < s.length; right++) {
        let c = (s.charCodeAt(right) - 65);
        count[c]++;
        if (c != maxIndex) {
            if (count[c] > count[maxIndex])
                maxIndex = c;
            else
                k--;
            while (k < 0) {
                let cLeft = s.charCodeAt(left++) - 65;
                count[cLeft]--;
                if (cLeft == maxIndex) {
                    let newMaxIndex = maxIndex;
                    count.forEach((c, i) => c > count[newMaxIndex] ? newMaxIndex = i : 0);
                    if (newMaxIndex != maxIndex) {
                        maxIndex = newMaxIndex;
                        k++;
                    }
                } else
                    k++;
            }       
        }
        maxWindow = Math.max(maxWindow, right - left + 1);
    }
    return maxWindow;
};
