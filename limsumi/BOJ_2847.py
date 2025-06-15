n = int(input())
li = [int(input()) for i in range(n)]

ans = 0
for i in range(n - 2, -1, -1):
    if li[i] >= li[i + 1]:
        tmp = li[i] - li[i + 1] + 1
        li[i] -= tmp
        ans += tmp

print(ans)
