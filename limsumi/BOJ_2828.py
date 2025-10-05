N, M = map(int, input().split())
J = int(input())

left, right = 1, M
ans = 0

for i in range(J):
    tmp = int(input())
    if tmp < left:
        ans += left - tmp
        left = tmp
        right = tmp + M - 1
    elif tmp > right:
        ans += tmp - right
        right = tmp
        left = tmp - M + 1

print(ans)
