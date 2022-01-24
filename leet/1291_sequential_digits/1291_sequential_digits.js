// LeetCode 1291. Sequential Digits
// https://leetcode.com/problems/sequential-digits/
// O(logn) time, O(1) space
var sequentialDigits = function(low, high) {
    let digits = Math.floor(Math.log(low) / Math.log(10)) + 1;
    let maxDigits = Math.floor(Math.log(high) / Math.log(10)) + 1;
    solution = [];
    let number = 0
    for (; digits <= maxDigits; digits++) {
        for (let start = 1; digits <= 10 - start; start++) {
            number = 0;
            for (let digit = start, i = 0; i < digits; digit++, i++)
                number = number * 10 + digit;
            if (number >= low && number <= high)
                solution.push(number);
        }
    }
    return solution;
};
