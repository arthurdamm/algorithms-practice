# Rainwater Peaks & Valleys Interview problem
# Finds the maximum rainwater stored in "bar graph" given by array

def rainwater(arr=[]):
    # Prepare first pass from left-to-right
    maxPeak = 0
    maxLeftPeaks = [0] * len(arr)
    for i in range(len(arr)):
        maxLeftPeaks[i] = maxPeak
        # if is peak and larger than previous max peak, replace
        if arr[i] > maxPeak:
            maxPeak = arr[i]

    # Prepare second pass from right-to-left
    maxPeak = 0
    maxRightPeaks = [0] * len(arr)
    water = 0
    for i in range(len(arr) - 1, -1, -1):
        maxRightPeaks[i] = maxPeak
        # calculate water level
        level = min(maxLeftPeaks[i], maxRightPeaks[i])
        # if level is above current node, it holds water
        if level > arr[i]:
            water += level - arr[i]
        # if is peak and larger than previous max peak, replace
        if arr[i] > maxPeak:
            maxPeak = arr[i]

    return water

if __name__ == "__main__":
    arr = [2, 5, 0, 0, 0, 1, 0, 0, 0, 5, 1]
    print("Rainwater of ", arr, "is", rainwater(arr))
    arr = [0, 1, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    print("Rainwater of ", arr, "is", rainwater(arr))
