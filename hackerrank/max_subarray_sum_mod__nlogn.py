import bisect

# Complete the maximumSum function below.
def maximumSum(a, m):
    ret = curr = 0
    sortedPrefixes = []
    for num in a:
        curr = (curr + num) % m
        pre = bisect.bisect_right(sortedPrefixes, curr)
        if pre != len(sortedPrefixes):
            ret = max(ret, curr, (curr - sortedPrefixes[pre] + m) % m)
        else:
            ret = max(ret, curr)
        bisect.insort(sortedPrefixes, curr)
    return ret
