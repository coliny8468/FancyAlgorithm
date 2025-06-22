N = int(input())

ans = 0

for i in range(1, N + 1):
    li = list(map(int, str(i)))
    if i < 100 or li[0] - li[1] == li[1] - li[2]:
        ans += 1

print(ans)
