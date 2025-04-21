import sys

N, M = map(int, sys.stdin.readline().split())

pkg = N // 6
rest = pkg
if N % 6:
    rest = pkg + 1


minn = 2e9
minP = 2e9
minS = 2e9

for i in range(M):
    x, y = map(int, input().split())

    minP = min(x, minP)
    minS = min(y, minS)


minn = min((minS * N), (minP * rest), ((minP * pkg) + ((N % 6) * minS)))


print(minn)
