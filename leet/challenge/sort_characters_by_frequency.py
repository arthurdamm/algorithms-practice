#!/usr/bin/env python3
"""
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
"""

from collections import Counter

class Solution:
    def frequencySort(self, s: str) -> str:
        return "".join([x[0]*x[1] for x in
                       sorted(list(Counter(s).items()),
                        key=lambda x:x[1], reverse=True)])
