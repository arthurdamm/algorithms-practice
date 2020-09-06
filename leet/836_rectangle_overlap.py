# LeetCode 836. Rectangle Overlap
class Solution:
    def isRectangleOverlap(self, rec1: List[int], rec2: List[int]) -> bool:
        x1, y1, x2, y2 = 0, 1, 2, 3
        if rec1[x1] >= rec2[x2] or rec2[x1] >= rec1[x2]:
            return False
        if rec1[y1] >= rec2[y2] or rec2[y1] >= rec1[y2]:
            return False
        return True

