#!/usr/bin/env python3
"""
Field and Towers interview question algorithm

O(n*log(m)) time complexity implementation
"""

def max_field_2(fields, towers):
    """
    Finds minimum-distant tower for each field with binary search and
    returns the max of these
    """
    return max([binary_search_tower(field, towers, None) for field in fields])

def binary_search_tower(field, towers, minimum):
    """Finds the minimum-distant tower for the given field"""
    if not len(towers):
        return minimum

    mid = (len(towers) - 1) // 2
    distance = field - towers[mid]
    if minimum is None or abs(distance) < minimum:
        minimum = abs(distance)
    if distance > 0: # field is more right than tower, so check tower to right
        return binary_search_tower(field, towers[mid + 1:len(towers)], minimum)
    else: # check tower to left
        return binary_search_tower(field, towers[0:mid], minimum)
    


def test_max_field(fields, towers):
    """Runs a test of max_field() for given fields and towers"""
    print("max_field where fields:", fields, "and towers:", towers)
    print(max_field_2(fields, towers))
    print()


test_max_field([1, 2, 3], [2])
test_max_field([1, 2, 3, 4], [1, 4])
test_max_field([1, 4], [10])
test_max_field([1, 10, 100], [2, 11])
test_max_field([0, 2, 232, 999], [1, 11, 20, 300, 1001])
test_max_field([0], [0])