from collections import defaultdict

N, M = map(int, input().split())
li = [input() for _ in range(N)]

ans = ""
ansham = 0

for i in range(M):
    count = defaultdict(int)
    for j in range(N):
        count[li[j][i]] += 1

    maxx = min(count.keys(), key=lambda x: (-count[x], x))
    ans += maxx

    ansham += N - count[maxx]

print(ans)
print(ansham)
