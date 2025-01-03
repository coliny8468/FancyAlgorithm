import sys


def check(s):
    return s == s[::-1]


word = sys.stdin.readline().rstrip()

leng = len(word)

ans = -1

if not check(word):
    print(leng)
else:
    flag = False
    for i in word:
        if i != word[0]:
            flag = True
    if flag:
        print(leng - 1)
    else:
        print(-1)
