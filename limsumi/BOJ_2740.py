N, M = map(int, input().split())
K = [list(map(int, input().split())) for _ in range(N)]

X, Y = map(int, input().split())
Z = [list(map(int, input().split())) for _ in range(X)]

ans = [[0] * Y for _ in range(N)]

for i in range(N):
    for j in range(Y):
        for k in range(M):
            ans[i][j] += K[i][k] * Z[k][j]

for i in ans:
    print(*i)
