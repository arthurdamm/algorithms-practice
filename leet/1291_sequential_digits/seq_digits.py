def seqDigits(low, high):
	nums = []
	for numDigits in range(1, 10):
		for startingDigit in range(1, 9 - numDigits + 2):
			firstDigit = startingDigit
			num = firstDigit
			for _ in range(1, numDigits):
				firstDigit += 1
				num = 10 * num + firstDigit
			if num > high:
				return nums
			if num >= low:
				nums.append(num)
	return num
