N, K = map(int, input().split())
items = [tuple(map(int, input().split())) for _ in range(N)]

dp = [0] * (K + 1)

for W, V in items:
    for j in range(K, W - 1, -1):
        dp[j] = max(dp[j], dp[j - W] + V)

print(dp[K])


# 물건을 돌면서 자기가 들어갈 수 있는 자리까지 최댓값을 계산하며 넣어보기
