A, B, N = map(int, input().split())

tmp = A % B
ans = 0

for i in range(N):
    tmp *= 10
    ans = tmp // B
    tmp %= B

print(ans)
