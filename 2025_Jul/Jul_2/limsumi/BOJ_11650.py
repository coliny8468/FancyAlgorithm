import sys

N = int(sys.stdin.readline())
li = [list(map(int, sys.stdin.readline().split())) for i in range(N)]

li.sort()

for x, y in li:
    print(x, y)
