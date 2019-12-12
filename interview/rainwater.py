# Rainwater Peaks & Valleys Interview problem
# Finds the maximum rainwater stored in "bar graph" given by array

def rainwater(arr=[]):
    # Prepare first pass from left-to-right
    largestLeftPeak = 0
    leftPeaks = [0 for x in arr]
    for i in range(len(arr)):
        leftPeaks[i] = largestLeftPeak
        # if is peak and larger than previous max peak, replace
        if (i == 0 or arr[i] >= arr[i - 1]) and\
           (i == len(arr) - 1 or arr[i] > arr[i + 1]) and\
           arr[i] > largestLeftPeak:
           largestLeftPeak = arr[i]
           #print("largestLeftPeak is now:", largestLeftPeak)

    # Prepare second pass from right-to-left
    largestRightPeak = 0
    rightPeaks = [0 for x in arr]
    water = 0
    for i in range(len(arr) - 1, -1, -1):
        rightPeaks[i] = largestRightPeak
        # calculate water level
        level = min(leftPeaks[i], rightPeaks[i])
        if level > arr[i]:
            water += level - arr[i]
        # if is peak and larger than previous max peak, replace
        if (i == len(arr) - 1 or arr[i] >= arr[i + 1]) and\
           (i == 0 or arr[i] > arr[i - 1]) and \
           arr[i] > largestRightPeak:
           largestRightPeak = arr[i]
           #print("largestRightPeak is now:", largestRightPeak)

    return water

if __name__ == "__main__":
    arr = [0, 5, 0, 0, 0, 4, 0, 0, 0, 5, 1]
    print("Rainwater of ", arr, "is", rainwater(arr))
    arr = [0, 1, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    print("Rainwater of ", arr, "is", rainwater(arr))
