# LeetCode 10. Regular Expression Matching

class Solution:    
    def isMatch(self, s, p):
        memo = {}
        def _isMatch(s, i, p, j):
            if (i, j) in memo: return False
            memo[(i, j)] = True
            if i >= len(s): # must match nothing
                while j < len(p):
                    if j + 1 < len(p) and p[j + 1] == '*': j += 2
                    else: break
                return j == len(p) or (j + 2 == len(p) and p[j + 1] == '*')
            if j >= len(p): # but s is not finished per above
                return False
            if j + 1 < len(p) and p[j + 1] == '*':
                if p[j] == '.':
                    return _isMatch(s, i + 1, p, j + 2) or _isMatch(s, i + 1, p, j) or _isMatch(s, i, p, j + 2)
                elif s[i] == p[j]:
                    return _isMatch(s, i + 1, p, j) or _isMatch(s, i, p, j + 2)
                else:
                    return _isMatch(s, i, p, j + 2)
            if p[j] == '.':
                return _isMatch(s, i + 1, p, j + 1)
            if s[i] == p[j]:
                return _isMatch(s, i + 1, p, j + 1)
            return False
        return _isMatch(s, 0, p, 0)

