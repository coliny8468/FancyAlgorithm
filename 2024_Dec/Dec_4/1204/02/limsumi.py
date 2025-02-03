from itertools import combinations
import sys

N, M = map(int, sys.stdin.readline().rstrip().split())

li = [set(sys.stdin.readline().rstrip().strip()) for _ in range(N)]

for i in range(N):
    li[i] -= {"a", "n", "t", "i", "c"}

if M < 5:
    print(0)
else:
    alpha = set("bdefghjklmopqrsuvwxyz")

    count = M - 5

    ans = 0
    for word in combinations(alpha, count):
        count = 0

        for x in li:
            if x.issubset(word):
                count += 1

        ans = max(ans, count)

    print(ans)
