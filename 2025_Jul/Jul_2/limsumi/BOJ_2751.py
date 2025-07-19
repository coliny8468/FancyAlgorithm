import sys

N = int(sys.stdin.readline())
li = [int(sys.stdin.readline()) for i in range(N)]

li.sort()

for x in li:
    print(x)
