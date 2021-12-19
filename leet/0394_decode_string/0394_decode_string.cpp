// LeetCode 394. Decode String
// https://leetcode.com/problems/decode-string/
// O(n) time-and-space
class Solution {
public:
    string decodeString(string s) {
        vector<string> substrStack;
        vector<int> numStack;
        string substr = "";
        int num = 0;
        for (auto c : s) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                substrStack.push_back(substr);
                substr = "";
                numStack.push_back(num);
                num = 0;
            } else if (c == ']') {
                string repeated = "";
                for (int n = numStack.back(); n > 0; n--)
                    repeated += substr;
                substr = substrStack.back() + repeated;
                numStack.pop_back();
                substrStack.pop_back();
            } else {
                substr += c;
            }
        }
        return substr;
    }
};
