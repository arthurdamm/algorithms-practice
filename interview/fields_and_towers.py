#!/usr/bin/env python3
"""
Field and Towers interview question algorithm

O(n) time complexity implementation
"""

def max_field(fields, towers):
    """
    Finds the minimum distance between each field and the nearest
    tower and stores these in a list. Then returns max of this list.
    """

    # preallocate minimum_distances to size of fields
    # we initialize to None because there may be no towers to the right
    # of a given field in which case it would not have a distance set
    # by the first-pass going from left to right and we need to know this
    # on the second-pass right-to-left. More on this below...
    minimum_distances = [None] * len(fields)

    # find the minimum distance between each field and the nearest
    # tower going from left to right.
    #
    # initialize iterators to far-left start of each list
    i = j = 0
    while i < len(fields) and j < len(towers):
        # Only compare fields to towers that are to the RIGHT of the field
        if fields[i] <= towers[j]:
            # this will be the NEAREST tower going from left to right
            minimum_distances[i] = towers[j] - fields[i]
            # check the next field to the right with this tower
            i = i + 1
        else:
            # this tower is to the left, check if the next tower is right
            j = j + 1

    # initialize iterators to far-right end of each list
    i = len(fields) - 1
    j = len(towers) - 1
    # find the minimum distance between each field and the nearest
    # tower now going backwards from right to left.
    while i >= 0 and j >= 0:
        # Only compare fields to towers that are to the LEFT of the field
        if fields[i] >= towers[j]:
            # this will be the NEAREST tower going from right to left
            # Check if this is less than our previous left-to-right-distance
            if minimum_distances[i] is None or fields[i] - towers[j] < minimum_distances[i]:
                minimum_distances[i] = fields[i] - towers[j]
            # check the next field to the left with this tower
            i = i - 1
        else:
            # this tower is to the right, check if the next one is left
            j = j - 1

    # with left-and-right passes we now have the minimum distances between
    # each field and the closest (either to the left or to the right) tower.
    # return the max of these for the solution.
    return max(minimum_distances)


def test_max_field(fields, towers):
    """Runs a test of max_field() for given fields and towers"""
    print("max_field where fields:", fields, "and towers:", towers)
    print(max_field(fields, towers))
    print()


test_max_field([1, 2, 3], [2])
test_max_field([1, 2, 3, 4], [1, 4])
test_max_field([1, 4], [10])
test_max_field([1, 10, 100], [2, 11])
test_max_field([0, 2, 232, 999], [1, 11, 20, 300, 1001])
test_max_field([0], [0])
