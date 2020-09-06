# LeetCode 1401. Circle and Rectangle Overlapping
class Solution:
    def checkOverlap(self, radius: int, x_center: int, y_center: int, x1: int, y1: int, x2: int, y2: int) -> bool:
        closerX = x1 if x_center < x1 else x2 if x2 < x_center else x_center
        closerY = y1 if y_center < y1 else y2 if y2 < y_center else y_center
        return (closerX - x_center)**2 + (closerY - y_center)**2 <= radius**2
