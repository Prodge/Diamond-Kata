import sys
from diamond_kata import letter_at_row, start_spaces, middle_spaces, get_diamond, get_diamond_top, get_row

def test_letter_at_row():
    assert letter_at_row(0) == 'a'
    assert letter_at_row(1) == 'b'
    assert letter_at_row(2) == 'c'

def test_start_spaces():
    assert start_spaces(1, 2) == ' '
    assert start_spaces(2, 4) == '  '
    assert start_spaces(0, 4) == '    '

def test_middle_spaces():
    assert middle_spaces(1) == ' '
    assert middle_spaces(2) == '   '
    assert middle_spaces(3) == '     '

def test_get_row():
    assert get_row(0, 2) == '  a'
    assert get_row(1, 2) == ' b b'
    assert get_row(2, 2) == 'c   c'

def test_get_diamond_top():
    assert get_diamond_top(0) == ['a']
    assert get_diamond_top(1) == [' a', 'b b']
    assert get_diamond_top(2) == ['  a', ' b b', 'c   c']

def test_get_diamond():
    assert get_diamond(0) == ['a']
    assert get_diamond(1) == [' a', 'b b', ' a']
    assert get_diamond(2) == ['  a', ' b b', 'c   c', ' b b', '  a']

def runner():
    this_module = sys.modules[__name__]
    tests = list(map(lambda f:getattr(this_module, f)(), filter(lambda f: f.startswith('test_'), dir(this_module))))
    print("All ({}) tests passed!".format(len(tests)))

runner()
