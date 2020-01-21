# LeetCode 17. Letter Combinations of a Phone Number
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits: return []
        phone = {'1': '', '2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', 
                 '6': 'mno', '7': 'pqrs', '8': 'tuv', '9':'wxyz', '0': ''}
        combos = ['']
        for digit in digits:
            combos = [combo + letter for letter in phone[digit] for combo in combos]
        return combos

