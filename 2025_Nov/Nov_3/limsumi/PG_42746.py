from functools import cmp_to_key

def compare(a, b):
    if a+b > b+a:
        return -1
    elif a+b < b+a:
        return 1
    else:
        return 0

def solution(numbers):
    str_list = list(map(str, numbers))
    str_list.sort(key=cmp_to_key(compare))
    answer = ''.join(str_list)

    return str(int(answer))
