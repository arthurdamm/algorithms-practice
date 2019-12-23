class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        d = {}
        ret = []
        for i in range(0, len(s) - 9):
            sub = s[i:i+10]
            d[sub] = d.get(sub, 0) + 1
            if d.get(sub, 0) == 2:
                ret.append(sub)
        return ret
