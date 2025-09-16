N, M = map(int, input().split())

li = [[0] * 101 for i in range(101)]


for i in range(N):
    x, y, k, l = map(int, input().split())

    for i in range(x, k + 1):
        for j in range(y, l + 1):
            li[i][j] += 1
ans = 0
for i in range(1, 101):
    for j in range(1, 101):
        if li[i][j] > M:
            ans += 1
print(ans)
