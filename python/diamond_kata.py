#!/usr/bin/python

'''

    Diamond Kata by prodge

'''

import sys

def letter_at_row(row):
    return chr(ord('a') + row)

def start_spaces(row, order):
    return ' ' * (order - row)

def middle_spaces(row):
    return ' ' * (row * 2 - 1)

def get_row(row, order):
    if row == 0:
        return ' ' * order + letter_at_row(row)
    return start_spaces(row, order) + letter_at_row(row) + middle_spaces(row) + letter_at_row(row)

def get_diamond_top(order):
    return [get_row(row, order) for row in range(order + 1)]

def get_diamond(order):
    top = get_diamond_top(order)
    return top + top[::-1][1:]

def main(args):
    if len(args) > 1:
        letter = args[1]
        order = ord(letter) - ord('a')
        list(map(print, get_diamond(order)))

main(sys.argv)
