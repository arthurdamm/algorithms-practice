#!/usr/bin/env python3
'''Too Sweet - Interview Algorithm Problem'''

import sys

# Constant determining the minimum number of teaspoons for which isTooSweet() returns true
# Will be the solution we are looking for
TOO_SWEET = 1

def isTooSweet(i):
	'''Returns true if teaspoons i is equal to or greater than our constant TOO_SWEET'''
	return i >= TOO_SWEET


def tooSweet0(n):
	'''Linear O(n) time, constant O(1) space solution'''
	# Iterate teaspoons from 1 to n
	for i in range(1, n + 1):
		# Our solution is the first number that is too sweet
		if isTooSweet(i):
			return i


def tooSweet1(n):
	'''Logarithmic O(logn) time, optimistically linear O(n) space solution'''
	# Populate a list with elements 1 to n
	arr = [x for x in range(1, n + 1)]
	# when the list has just 1 element we'll know our solution
	while len(arr) > 1:
		# select the midpoint as half our list length using floor divison
		mid = len(arr) // 2
		#print(arr, mid)
		# if it's too sweet select everything to the left of it
		if isTooSweet(arr[mid]):
			arr = arr[:mid]
		# else if not too sweet include this element and select right
		else:
			arr = arr[mid:]

	# there is an edge case when the loop result is [1]
	# the loop can't differentiate if 1 is too sweet or 2 so we have to do one more check:
	if arr[0] == 1 and isTooSweet(1):
		return 1
	# Otherwise the list now contains 1 element which is the last number of teaspoons
	# that is NOT too sweet so by adding 1 to it we get the first number that IS too sweet.
	else:
		return arr[0] + 1



def tooSweet2(n):
	'''Logarithmic O(logn) time, constant O(1) space solution'''
	# initialize left to 1 and right to n
	left = 1
	right = n
	# loop until left == right
	while left < right:
		# this is equivalent to mid = (left + right) // 2 but prevents integer overflow
		mid = left + (right - left) // 2
		#print(left, mid, right)
		# if mid is too sweet make it the new right
		if isTooSweet(mid):
			right = mid
		else:
		# otherwise set left to the next number to the right of mid
			left = mid + 1
	# left now equals right and is the first teaspoon number to be too sweet
	# so mid == left == right but lets compute again to be consistent
	mid = left + (right - left) // 2
	return mid

if __name__ == "__main__":
	'''Command line testing script'''
	if len(sys.argv) < 3:
		print("USAGE: ./toosweet.py <TOO_SWEET> <n>")
		exit()
	TOO_SWEET = int(sys.argv[1])
	num = int(sys.argv[2])
	if num < TOO_SWEET:
		print("ERROR: n must be greater than or equal to the TOO_SWEET constant")
		exit()
	print("tooSweet0():", tooSweet0(num))
	print("tooSweet1():", tooSweet1(num))
	print("tooSweet2():", tooSweet2(num))
	for i in range(1, 200):
		TOO_SWEET = i
		for j in range(i, 200):
			num = tooSweet0(j)
			if tooSweet1(j) != num or tooSweet2(j) != num:
				print("Error", i, j)
	print("Done.")
