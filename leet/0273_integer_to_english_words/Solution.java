// LeetCode 273. Integer to English Words
// https://leetcode.com/problems/integer-to-english-words/
// O(logn) time and space
// LeetCode 273. Integer to English Words
// https://leetcode.com/problems/integer-to-english-words/
// O(logn) time and space
class Solution {
    String[] ones = {"Zero", "One", "Two", "Three", "Four", "Five",
                        "Six", "Seven", "Eight", "Nine"};
    String[] teen = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                   "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
                     "Seventy", "Eighty", "Ninety"};
    String[] chunks = {"", "Thousand ", "Million ", "Billion "};
    
    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0)
            return "Zero";
        for (int i = 0; num > 0; i++, num /= 1000)
            if (num % 1000 != 0)
                sb.insert(0, chunks[i]).insert(0, chunk(num % 1000));
        return sb.toString().trim();
    }
    
    String chunk(int n) {
        StringBuilder sb = new StringBuilder();
        if (n / 100 > 0)
            sb.append(ones[n / 100]).append(" Hundred ");
        n %= 100;
        if (n / 10 == 1)
            sb.append(teen[n % 10]).append(' ');
        else {
            if (n / 10 > 1)
                sb.append(tens[n / 10]).append(' ');
            n %= 10;
            if (n > 0)
                sb.append(ones[n]).append(' ');
        }
        return sb.toString();
    }
}
