#!/usr/bin/env python3
"""
Field and Towers interview question algorithm

O(n*log(m)) time complexity implementation
"""

def max_field_3(fields, towers):
    """
    Finds minimum-distant tower for each field with binary search and
    returns the max of these
    """
    return max([min([abs(field - tower) for tower in towers]) for field in fields])


def test_max_field(fields, towers):
    """Runs a test of max_field() for given fields and towers"""
    print("max_field where fields:", fields, "and towers:", towers)
    print(max_field_3(fields, towers))
    print()


test_max_field([1, 2, 3], [2])
test_max_field([1, 2, 3, 4], [1, 4])
test_max_field([1, 4], [10])
test_max_field([1, 10, 100], [2, 11])
test_max_field([0, 2, 232, 999], [1, 11, 20, 300, 1001])
test_max_field([0], [0])