n = int(input())
cur = int(input())

if n == 1:
    print(0)
else:
    candi = [int(input()) for i in range(n - 1)]
    ans = 0

    while candi and max(candi) >= cur:
        maxx = candi.index(max(candi))
        candi[maxx] -= 1
        cur += 1
        ans += 1

    print(ans)
